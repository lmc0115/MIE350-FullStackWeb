package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "WebUser")
public class WebUser {
   
    @Id
    @NotEmpty
    private String username;

    @ManyToOne
    @JoinColumn(name="Team")
    @Nullable
    private Team Team;
    
    @ManyToOne
    @JoinColumn(name="Player")
    @Nullable
    private Player Player;

    public WebUser(String username, Team Team, Player Player){
        this.username = username;
        this.Team = Team;
        this.Player = Player;
    }

}
