package com.dio.amazon.apirestamazon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String helloWord(){
        return ("This is my first API in Spring Boot");
    }

    @GetMapping
    public List<Person> findAll(){
        return personRepository.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id){
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found"));
    }


}
