package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter


public class UserPostKey implements Serializable {
    @Column(name = "username")
    String username;

    @Column(name = "Team")
    String Team;

    @Column(name = "Player")
    String Player;

    @Override
    public int hashCode() {
        String concatString = String.valueOf(username.hashCode()) + String.valueOf(Team.hashCode()) + String.valueOf(Player.hashCode());
        return concatString.hashCode();
    }
    public UserPostKey(){}

    public UserPostKey(String username, String Team, String Player){
        this.setUsername(username);
        this.setTeam(Team);
        this.setPlayer(Player);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if (o == this)
            return true;
        if (!(o instanceof UserPostKey))
            return false;
        UserPostKey other = (UserPostKey) o;
        return username.equals(other.username) && Team.equals(other.Team) && Player.equals(other.Player);
    }























}
