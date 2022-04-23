package com.fc.controller;

import com.fc.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;

@RestController
@RequestMapping("person")
public class PersonController {
    @Autowired
    private Person person;
    @RequestMapping("getPerson")
    public Person getPerson(){
        return person;
    }
}
