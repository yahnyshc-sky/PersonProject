package com.qa.PersonProject.services;

import com.qa.PersonProject.entities.Person;
import com.qa.PersonProject.entities.PersonRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private PersonRepo repo;

    public PersonService(PersonRepo repo){
        super();
        this.repo = repo;
    }

    public String health() {
        return "My health is ok";
    }

    public boolean addPerson(Person person){
        Person savedPerson = null;
        savedPerson = this.repo.save(person);
        return savedPerson.getId() > 0;
    }

    public List<Person> getAll() {
        return this.repo.findAll();
    }

    public Person updatePerson(Long id, Person person){
        Optional<Person> existingOptionalPerson = this.repo.findById(id);
        Person existing = existingOptionalPerson.get();
        existing.setAge(person.getAge());
        existing.setFirstName(person.getFirstName());
        existing.setLastName(person.getLastName());
        return this.repo.save(existing);

    }

    public boolean removePerson(Long id){
        this.repo.deleteById(id);
        return !this.repo.existsById(id);
    }

}
