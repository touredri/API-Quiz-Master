package com.odk3.projet_tp_api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Not Null de base de donnée
    @Column(nullable = false)
    private int idQuestion;

    // Pour monter que le text est long
    @Lob

    // Not Null de base de donnée
    @Column(nullable = false)
    private String contenue;

    @ManyToOne
    @JoinColumn(name = "idUtilicateur", nullable = false)
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "idQuiz", nullable= false)
    private Quiz quiz;



}
