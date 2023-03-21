package com.example.cms.controller;

import com.example.cms.controller.exceptions.UserPostNotFoundException;
import com.example.cms.model.entity.UserPost;
import com.example.cms.model.repository.UserPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserPostController {
    @Autowired
    private final UserPostRepository repository;

    public UserPostController(UserPostRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/userpost")
    List<UserPost> retrieveAllUserPost() {
        return repository.findAll();
    }

    @PostMapping("/userpost")
    UserPost createUserPost(@RequestBody UserPost newUserPost) {
        return repository.save(newUserPost);
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
    
    
    
    
    

    @PutMapping("/userpost/{id}")
    UserPost updateUserPost(@RequestBody UserPost newUserPost, @PathVariable("id") Long postId) {

        return repository.findById(postId)
                .map(userpost -> {
                    userpost.setTeam(newUserPost.getTeam());
                    userpost.setPlayer(newUserPost.getPlayer());
                    userpost.setPost(newUserPost.getPost());
                    
                    return repository.save(userpost);
                })
                .orElseGet(() -> {
                    newUserPost.setPostId(postId);
                    return repository.save(newUserPost);
                });
    }

    @DeleteMapping("/userpost/{id}")
    void deleteUserPost(@PathVariable("id") Long postId) {
        repository.deleteById(postId);
    }
}
