package com.example.cms.controller;

import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.WebUser;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<WebUser> retrieveAllUser() {
        return repository.findAll();
    }

    @PostMapping("/user")
    WebUser createUser(@RequestBody WebUser newUser) {
        return repository.save(newUser);
    }

    @GetMapping("/user/{username}")
    List<WebUser> retrieveStudent(@PathVariable("username") String username) {
        return repository.searchUser(username);
    }


    @PutMapping("/user/{username}")
    WebUser updateUser(@RequestBody WebUser newUser, @PathVariable("username") String username) {
        return repository.findById(username)
                .map(WebUser -> {
                    WebUser.setUsername(newUser.getUsername());
                    WebUser.setTeam(newUser.getTeam());
                    WebUser.setPlayer(newUser.getPlayer());
                    return repository.save(WebUser);
                })
                .orElseGet(() -> {
                    newUser.setUsername(username);
                    return repository.save(newUser);
                });

    }
 
}
