package de.htwberlin.Webtechnologien.web;

import de.htwberlin.Webtechnologien.persistence.PersonRepository;
import de.htwberlin.Webtechnologien.service.PersonService;
import de.htwberlin.Webtechnologien.web.api.Person;
import de.htwberlin.Webtechnologien.web.api.PersonCreateRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
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

    @PostMapping(path = "/api/v1/persons")
    public ResponseEntity<Void> createPerson(@RequestBody PersonCreateRequest request) throws URISyntaxException {
        var person = personService.create(request);
        URI uri = new URI("/api/v1/persons/" + person.getId()); // adresse der neu erzeugten Ressourcen in der datenbank
        return ResponseEntity.created(uri).build();
    }
}
