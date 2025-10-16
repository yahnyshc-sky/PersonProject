package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.services.PersonService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private PersonService service;

    public PersonController(PersonService service){
        super();
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "My health is ok";
    }

    @PostMapping("/create")
    public boolean addPerson(@RequestBody @Valid Person person){
        return this.service.addPerson(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.service.getAll();
    }

    @PutMapping("/update")
    public Person updatePerson(@PathParam("id")Long id,@RequestBody @Valid Person person){
        return this.service.updatePerson(id, person);
    }

    @DeleteMapping("/delete/{id}")
    public boolean removePerson(@PathVariable Long id){
        return this.service.removePerson(id);
    }

}
