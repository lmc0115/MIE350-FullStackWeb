package com.example.cms.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Team")
public class Team {

    @Id
    @NotEmpty
    private String Team;

    @NotEmpty
    private String NofPl;

    @NotEmpty
    private String Age;
    
    @NotEmpty
    private String Poss;
    
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

    public Team (String Team, String NofPl, String Age, String Poss, String MP, String Starts, String nMin, 
                 String Gls, String Ast, String G_PK, String PK, String PKatt, String CrdY, String CrdR){
        this.Team = Team;
        this.NofPl = NofPl;
        this.Age = Age;
        this.MP = MP;
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
