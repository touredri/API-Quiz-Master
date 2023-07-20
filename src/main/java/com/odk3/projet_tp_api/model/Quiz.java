package com.odk3.projet_tp_api.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Quiz {
    @NotNull(message = "champs null")
    @Id
    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.AUTO)
    // note null
    @Column(nullable = false)
    private int idQuiz ;

    @NotNull(message = "champs null")
    @Size(min = 5, message = "titre court")
    @Column(nullable = false)
    private String Titre;
}

