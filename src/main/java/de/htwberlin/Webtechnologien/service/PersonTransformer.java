package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.Gender;
import de.htwberlin.Webtechnologien.persistence.PersonEntity;
import de.htwberlin.Webtechnologien.persistence.RechnungEntity;
import de.htwberlin.Webtechnologien.web.api.Person;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class PersonTransformer {

    public Person transformEntity(PersonEntity personEntity){
        var gender = personEntity.getGender() != null ? personEntity.getGender().name() : Gender.UNKNOWN.name();
        var rechnungIds = personEntity.getRechnungen().stream().map(RechnungEntity::getId).collect(Collectors.toList());
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                gender,
                personEntity.getMember(),
                rechnungIds);
    }
}
