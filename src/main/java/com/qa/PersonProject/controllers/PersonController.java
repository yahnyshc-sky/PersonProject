package com.qa.PersonProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/health")
    public String health() {
        return "My health is ok";
    }
}
