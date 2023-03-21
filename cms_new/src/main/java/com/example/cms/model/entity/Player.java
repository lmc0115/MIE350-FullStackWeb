package com.example.cms.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Player")
public class Player {

    @NotEmpty
    @ManyToOne
    @JoinColumn(name = "Team")
    private Team Team;
    
    @Id
    @NotEmpty
    private String Player;

    @NotEmpty
    private String Nation;

    @NotEmpty
    private String Pos;

    @NotEmpty
    private String Age;
    
    @NotEmpty
    private String MP;
    
    @NotEmpty
    private String Starts;
    
    @NotEmpty
    private String nMin;
    
    @NotEmpty
    private String Gls;
    
    @NotEmpty
    private String Ast;
    
    @NotEmpty
    private String G_PK;
    
    @NotEmpty
    private String PK;
    
    @NotEmpty
    private String PKatt;
    
    @NotEmpty
    private String CrdY;
    
    @NotEmpty
    private String CrdR;
    
    public Player(Team Team, String Player, String Nation, String Pos, String Age, String Starts, String nMin, 
                  String Gls, String Ast, String G_PK, String PK, String PKatt, String CrdY, String CrdR){
        this.Team = Team;
        this.Player = Player;
        this.Nation = Nation;
        this.Pos = Pos;
        this.Age = Age;
        this.Starts = Starts;
        this.nMin = nMin;
        this.Gls = Gls;
        this.Ast = Ast;
        this.G_PK = G_PK;
        this.PK = PK;
        this.PKatt = PKatt;
        this.CrdY = CrdY;
        this.CrdR = CrdR;
        }
}
