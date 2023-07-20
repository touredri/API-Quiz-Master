package com.odk3.projet_tp_api.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Quiz {
    @Id
    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.AUTO)
    // note null
    @Column(nullable = false)
    private int idQuiz ;
    @Column(nullable = false)
    private String Titre;
}

