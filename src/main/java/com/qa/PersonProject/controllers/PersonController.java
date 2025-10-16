package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private List<Person> people = new ArrayList<>();

    @GetMapping("/health")
    public String health() {
        return "My health is ok";
    }

    @PostMapping("/create")
    public boolean addPerson(@RequestBody @Valid Person person){
        return this.people.add(person);
    }

    @GetMapping("/getAll")
    public List<Person> getAll() {
        return this.people;
    }

    @PutMapping("/update")
    public Person updatePerson(@PathParam("id")Long id,@RequestBody @Valid Person person){
        this.people.remove(id.intValue());
        this.people.add(id.intValue(),person);
        return this.people.get(id.intValue());

    }

    @DeleteMapping("/delete/{id}")
    public Person removePerson(@PathVariable Long id){
        return this.people.remove(id.intValue());
    }

}
