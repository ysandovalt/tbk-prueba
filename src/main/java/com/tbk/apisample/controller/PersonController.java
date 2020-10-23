package com.tbk.apisample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tbk.apisample.exception.ResourceNotFoundException;
import com.tbk.apisample.model.Person;
import com.tbk.apisample.repository.PersonRepository;

@RestController
@RequestMapping("/api")
public class PersonController {
	
	Logger logger = LoggerFactory.getLogger(PersonController.class);
	
    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/personGetAll")
    public List<Person> getAllPersons() {
      logger.debug("personGetAll ");
      return personRepository.findAll();
    }

    @GetMapping("/personGet/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
        throws ResourceNotFoundException {

    	logger.debug("personGetById ",personId);

    	Person person = personRepository.findById(personId)
          .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada para id => " + personId));
        return ResponseEntity.ok().body(person);
    }
    
    @PostMapping("/personAdd")
    public Person createPerson(@Valid @RequestBody Person person) {
    	logger.debug("personAdd ",person.toString());
        return personRepository.save(person);
    }

    @PutMapping("/personUpdate/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
         @Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
            Person person = personRepository.findById(personId)
        .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada para id => " + personId));

    	logger.debug("personUpdate ",personDetails.toString());

    	person.setEmail(personDetails.getEmail());
        person.setApellido(personDetails.getApellido());
        person.setNombre(personDetails.getNombre());
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/personDelete/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
         throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
       .orElseThrow(() -> new ResourceNotFoundException("Persona no encontrada para id => " + personId));

    	logger.debug("personDelete ",person.toString());

    	personRepository.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}