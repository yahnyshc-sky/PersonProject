package com.qa.PersonProject.controllers;

import com.qa.PersonProject.entities.Person;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
