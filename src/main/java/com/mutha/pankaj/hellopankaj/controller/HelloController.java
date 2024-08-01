package com.mutha.pankaj.hellopankaj.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class HelloController {
    
    List<String> names = new ArrayList<>();

    @GetMapping("/")
    String sayHello() {
        if(names.size()==0) {
            return "nothing to display as of now";
        }
        return names.toString();
    }

    @PostMapping("/addName")
    public String addNameString(@RequestBody String name) {
        names.add(name);
        return name+" is added!";
    }

    @DeleteMapping("/deleteName")
    public String deleteNameString(@RequestBody String name) {
        return names
        .remove(name) 
        ? name+" is removed" 
        : name+" is not found";
    }

    


}
