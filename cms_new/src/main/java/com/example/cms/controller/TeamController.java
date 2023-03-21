package com.example.cms.controller;

//import com.example.cms.controller.dto.TeamDto;
import com.example.cms.controller.exceptions.TeamNotFoundException;
//import com.example.cms.controller.exceptions.ProfessorNotFoundException;
import com.example.cms.model.entity.Team;
//import com.example.cms.model.entity.Professor;
import com.example.cms.model.repository.TeamRepository;
//import com.example.cms.model.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TeamController {
    @Autowired
    private final TeamRepository repository;

    //@Autowired
    //private ProfessorRepository professorRepository;

    public TeamController(TeamRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/team")
    List<Team> retrieveAllTeam() {
        return repository.findAll();
    }

    

    @GetMapping("/team/{name}")
    Team retrieveTeam(@PathVariable("name") String teamName) {
        return repository.findById(teamName)
                .orElseThrow(() -> new TeamNotFoundException(teamName));
    }
    
    @GetMapping("/team/search/{teamname}")
    List<Team> retrieveTeamByName(@PathVariable("teamname") String TeamNSearchString) {
        return repository.findByTName(TeamNSearchString);
            //.orElseThrow(() -> new TeamNotFoundException(TeamNSearchString));
    }
}
