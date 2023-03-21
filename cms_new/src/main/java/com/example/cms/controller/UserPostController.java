package com.example.cms.controller;
import com.example.cms.controller.dto.UserPostDto;
import com.example.cms.controller.exceptions.UserNotFoundException;
import com.example.cms.controller.exceptions.TeamNotFoundException;
import com.example.cms.controller.exceptions.PlayerNotFoundException;
import com.example.cms.model.entity.UserPost;
import com.example.cms.model.entity.WebUser;
import com.example.cms.model.entity.Team;
import com.example.cms.model.entity.Player;
import com.example.cms.model.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.cms.model.entity.UserPostKey;
import com.example.cms.model.repository.UserRepository;
import com.example.cms.model.repository.PlayerRepository;
import com.example.cms.model.repository.TeamRepository;

import java.util.List;

@CrossOrigin
@RestController
public class UserPostController {
    @Autowired
    private final UserPostRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;


    public UserPostController(UserPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/userpost")
    List<UserPost> retrieveAllUserPost() {
        return repository.findAll();
    }

    @PostMapping("/userpost")
    UserPost createUserPost(@RequestBody UserPostDto userPostDto) {
        UserPost userPost = new UserPost();
        UserPostKey userPostKey = new UserPostKey(userPostDto.getUsername(),userPostDto.getTeam(), userPostDto.getPlayer());

        WebUser webuser = userRepository.findById(userPostDto.getUsername()).orElseThrow(()->
                new UserNotFoundException(userPostDto.getUsername()));
        userPost.setUsername(webuser);

        Team team = teamRepository.findById(userPostDto.getTeam()).orElseThrow(()->
                new TeamNotFoundException(userPostDto.getTeam()));
        userPost.setTeam(team);

        Player player = playerRepository.findById(userPostDto.getPlayer()).orElseThrow(()->
                new PlayerNotFoundException(userPostDto.getPlayer()));
        userPost.setPlayer(player);

        userPost.setPost(userPostDto.getPost());
        userPost.setPostId(userPostKey);
        return repository.save(userPost);
    }



    
    @GetMapping("/userpost/search/team/{teamname}")
    List<UserPost> retrieveUserPostByTeam(@PathVariable("teamname") String TeamSearchString) {
        return repository.findPostByTeam(TeamSearchString);
    }

    
    @GetMapping("/userpost/search/player/{playername}")
    List<UserPost> retrieveUserPostByPlayer(@PathVariable("playername") String PlayerSearchString) {
        return repository.findPostByPlayer(PlayerSearchString);
    }
    
    
     @GetMapping("/userpost/search/user/{username}")
    List<UserPost> retrieveUserPostByUser(@PathVariable("username") String UserSearchString) {
        return repository.findPostByUser(UserSearchString);
    }
    


    @PutMapping("/userpost/{username}/{Team}/{Player}")
    UserPost updateUserPost(@RequestBody UserPostDto userPostDto, @PathVariable("username") String username, @PathVariable("Team") String Team,  @PathVariable("Player") String Player) {
        UserPostKey findKey = new UserPostKey(username, Team, Player);
        return repository.findById(findKey).map(userPost -> {
            userPost.setPost(userPostDto.getPost());
            return repository.save(userPost);
        }).orElseGet(()->{
            return this.createUserPost(userPostDto);
        });
    }



    @DeleteMapping("/userpost/{username}/{Team}/{Player}")
    void deleteUserPost(@PathVariable("username") String username, @PathVariable("Team") String Team,  @PathVariable("Player") String Player) {
        UserPostKey findKey = new UserPostKey(username, Team, Player);
        repository.deleteById(findKey);
    }


}
