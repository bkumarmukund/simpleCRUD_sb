package com.mutha.pankaj.hellopankaj.controller;
import com.github.javafaker.Faker;
import com.mutha.pankaj.hellopankaj.models.User;
import com.mutha.pankaj.hellopankaj.models.UserUpdateRequest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    private static List<User> users = new ArrayList<>();
    
    static {
        Faker faker = new Faker();
        for (int i = 0; i < 20; i++) {
            users.add(new User(faker.name().name(), 30+i));
        }
        users.add(0,new User("nithin", 23));
        users.add(0,new User("abhinav", 22));
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return users;
    }

    @PostMapping("/users")
    public String addUser(@RequestBody User user) {

        int indexOfUser = users.indexOf(user);
        if(indexOfUser == -1) {
            users.add(0,user);
            return "user added";
        }
        return "user already present";
    }

    @PutMapping("/users")
    public String updateUser(@RequestBody UserUpdateRequest userUpdateData) {

        
        User oldUser = userUpdateData.getOldUser();
        User newUser = userUpdateData.getNewUser();

        int indexOfUser = users.indexOf(oldUser);
        if(indexOfUser == -1) {
            return "user not present";
        }
        users.set(indexOfUser, newUser);
        return "user details updated";
    }

    @DeleteMapping("/users")
    public String deleteUser(@RequestBody User user) {
        int indexOfUser = users.indexOf(user);
        if(indexOfUser == -1) {
            return "user not present";
        }
        users.remove(indexOfUser);
        return "user removed";
    }

}
