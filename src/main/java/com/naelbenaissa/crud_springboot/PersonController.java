package com.naelbenaissa.crud_springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/persons")
public class PersonController {
    final PersonRepository personRepository;
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person personCreated = personRepository.save(person);
        return new ResponseEntity<>(personCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        return personRepository.findById(id)
                .map(person -> new ResponseEntity<>(person, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable Long id, @RequestBody Person personDetails) {
        Optional<Person> person = personRepository.findById(id);

        if(person.isPresent()) {
            Person existingPerson = person.get();
            existingPerson.setCity(personDetails.getCity());
            existingPerson.setPhoneNumber(personDetails.getPhoneNumber());

            Person updatedPerson = personRepository.save(existingPerson);
            return new ResponseEntity<>(updatedPerson, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
