package de.htwberlin.Webtechnologien.web;

import de.htwberlin.Webtechnologien.persistence.PersonRepository;
import de.htwberlin.Webtechnologien.service.PersonService;
import de.htwberlin.Webtechnologien.web.api.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    private final PersonService personService;

    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/api/v1/persons")
   // @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Person>> fetchPerson() {
        return ResponseEntity.ok(personService.findAll());
    }

}
