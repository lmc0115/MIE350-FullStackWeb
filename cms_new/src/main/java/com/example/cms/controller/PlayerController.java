package com.example.cms.controller;

import com.example.cms.controller.exceptions.PlayerNotFoundException;
import com.example.cms.model.entity.Player;
import com.example.cms.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class PlayerController {
    @Autowired
    private final PlayerRepository repository;

    public PlayerController(PlayerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/player")
    List<Player> retrieveAllPlayers() {
        return repository.findAll();
    }

     @GetMapping("/player/{name}")
    Player retrieveTeam(@PathVariable("name") String playerName) {
        return repository.findById(playerName)
                .orElseThrow(() -> new PlayerNotFoundException(playerName));
    }
    
      @GetMapping("/player/search/{playername}")
    List<Player> retrievePlayerByName(@PathVariable("playername") String PlayerSearchString) {
        return repository.findPlayerByName(PlayerSearchString);

               // .orElseThrow(() -> new PlayerNotFoundException(PlayerSearchString));
    }

}
