package com.example.EcfEchec.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tournoi")
public class Tournoi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String NomTournoi;

    @OneToMany
    private List<Joueur>joueurs;

    @OneToMany
    private List<Partie>partieList;



}
