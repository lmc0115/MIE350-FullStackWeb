package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "UserPost")
public class UserPost {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long postId;

    @ManyToOne
    @JoinColumn(name="username")
    private WebUser username;

    @ManyToOne
    @JoinColumn(name="Team")
    @Nullable
    private Team Team;
    
    @ManyToOne
    @JoinColumn(name="Player")
    @Nullable
    private Player Player;

    @NotEmpty
    private String Post;
    
    public UserPost (Long postId, WebUser username, Team Team, Player Player, String Post){
        this.postId = postId;
        this.username = username;
        this.Team = Team;
        this.Player = Player;
        this.Post = Post;
    }

}
