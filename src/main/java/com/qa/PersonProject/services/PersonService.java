package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {
    private List<Person> people = new ArrayList<>();

    public String health() {
        return "My health is ok";
    }

    public boolean addPerson(Person person){
        return this.people.add(person);
    }

    public List<Person> getAll() {
        return this.people;
    }

    public Person updatePerson(Long id, Person person){
        this.people.remove(id.intValue());
        this.people.add(id.intValue(),person);
        return this.people.get(id.intValue());

    }

    public Person removePerson(Long id){
        return this.people.remove(id.intValue());
    }

}
