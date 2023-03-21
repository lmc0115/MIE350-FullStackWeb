package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "UserPost")
public class UserPost {


    @EmbeddedId
    UserPostKey postId;

    @ManyToOne
    @MapsId("username")
    @JoinColumn(name="username")
    @JsonIgnoreProperties({"posts"})
    private WebUser username;

    @ManyToOne
    @MapsId("Team")
    @JoinColumn(name="Team")
    @Nullable
    @JsonIgnoreProperties({"posts"})
    private Team Team;
    
    @ManyToOne
    @MapsId("Player")
    @JoinColumn(name="Player")
    @Nullable
    @JsonIgnoreProperties({"posts"})
    private Player Player;

    @NotEmpty
    private String Post;
    

}
