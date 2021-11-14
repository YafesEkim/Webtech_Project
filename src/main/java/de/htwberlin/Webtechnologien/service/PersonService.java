package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.PersonEntity;
import de.htwberlin.Webtechnologien.persistence.PersonRepository;
import de.htwberlin.Webtechnologien.web.api.Person;
import de.htwberlin.Webtechnologien.web.api.PersonCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream().
                map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person create(PersonCreateRequest request) {
        var personEntitiy = new PersonEntity(request.getFirstName(), request.getLastName(), request.isMember());
        personEntitiy = personRepository.save(personEntitiy);
        return transformEntity(personEntitiy);
    }

    private Person transformEntity(PersonEntity personEntity) {
        return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getMember()
        );
    }
}
