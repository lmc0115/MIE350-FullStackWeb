package com.example.cms.controller;

import com.example.cms.controller.dto.WebUserDto;
import com.example.cms.controller.exceptions.PlayerNotFoundException;
import com.example.cms.controller.exceptions.TeamNotFoundException;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.model.entity.Player;
import com.example.cms.model.entity.Team;
import com.example.cms.model.entity.WebUser;
import com.example.cms.model.repository.PlayerRepository;
import com.example.cms.model.repository.TeamRepository;
import com.example.cms.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    private final UserRepository repository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;


    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/user")
    List<WebUser> retrieveAllUser() {
        return repository.findAll();
    }

    @PostMapping("/user")
    WebUser createUser(@RequestBody WebUserDto webUserDto) {
        WebUser webUser = new WebUser();
        Player player = playerRepository.findById(webUserDto.getPlayer()).orElseThrow(()->
                new PlayerNotFoundException(webUserDto.getPlayer()));
        webUser.setPlayer(player);

        Team team = teamRepository.findById(webUserDto.getTeam()).orElseThrow(()->
                new TeamNotFoundException(webUserDto.getTeam()));
        webUser.setTeam(team);
        webUser.setUsername(webUserDto.getUsername());
        return repository.save(webUser);
    }

    @GetMapping("/user/{username}")
    List<WebUser> retrieveStudent(@PathVariable("username") String username) {
        return repository.searchUser(username);
    }


    @PutMapping("/user/{username}")
    WebUser updateUser(@RequestBody WebUserDto webUserDto, @PathVariable("username") String username) {
        return repository.findById(username)
                .map(WebUser -> {
                    Player player = playerRepository.findById(webUserDto.getPlayer()).orElseThrow(()->
                            new PlayerNotFoundException(webUserDto.getPlayer()));
                    WebUser.setPlayer(player);
                    Team team = teamRepository.findById(webUserDto.getTeam()).orElseThrow(()->
                            new TeamNotFoundException(webUserDto.getTeam()));
                    WebUser.setTeam(team);
                    return repository.save(WebUser);
                })
                .orElseGet(() -> {
                    return this.createUser(webUserDto);
                });
    }



}
