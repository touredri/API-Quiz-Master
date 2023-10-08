package com.odk3.projet_tp_api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Quiz {
    @Id

    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // note null de base de donnée
    @Column(nullable = false)
    private int idQuiz ;

    @NotNull(message = "champs vide")
    @Size(min = 5, message = "titre court")

    // Not Null de base de donnée
    @Column(nullable = false)
    private String titre;

    @Column
    private int timer;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur",nullable = false)
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "quiz", orphanRemoval = true) // orphan Removal permet de suppimer tout les id correspond
    @JsonIgnoreProperties(value = {"quiz","utilisateur"}) // il permet de ignorer tout les question ici
    private List<Question> questions = new ArrayList<>();
}

