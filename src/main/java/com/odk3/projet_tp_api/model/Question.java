package com.odk3.projet_tp_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Question {
    @Id
    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private int idQuestion;

    @Column(nullable = false)
    private String contenu;
}
