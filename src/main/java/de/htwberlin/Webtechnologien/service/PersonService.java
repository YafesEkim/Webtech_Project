package de.htwberlin.Webtechnologien.service;

import de.htwberlin.Webtechnologien.persistence.PersonEntity;
import de.htwberlin.Webtechnologien.persistence.PersonRepository;
import de.htwberlin.Webtechnologien.web.api.Person;
import de.htwberlin.Webtechnologien.web.api.PersonManipulationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService (PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<PersonEntity> persons = personRepository.findAll();
        return persons.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Person findById(Long id){
        var personEntity = personRepository.findById(id);
        return personEntity.isPresent()? transformEntity(personEntity.get()) : null;
    }

    public Person create(PersonManipulationRequest request){
        var personEntity = new PersonEntity(request.getFirstName(),request.getLastName(),request.isMember());
        personEntity = personRepository.save(personEntity);
        return transformEntity(personEntity);
    }

    public Person update (Long id, PersonManipulationRequest request){
        var personEntityOptional = personRepository.findById(id);
        if(personEntityOptional.isEmpty()){
            return null;
        }

        var personEntity = personEntityOptional.get();
        personEntity.setFirstName(request.getFirstName());
        personEntity.setLastName(request.getLastName());
        personEntity.setMember(request.isMember());

        personEntity = personRepository.save(personEntity);

        return transformEntity(personEntity);
    }

    public boolean deleteById(Long id){
        if(!personRepository.existsById(id)){
            return false;
        }

        personRepository.deleteById(id);
        return true;
    }

    private Person transformEntity(PersonEntity personEntity){
       return new Person(
                personEntity.getId(),
                personEntity.getFirstName(),
                personEntity.getLastName(),
                personEntity.getMember()
        );
    }
}
