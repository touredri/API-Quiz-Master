package com.odk3.projet_tp_api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Categorie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idCategorie;

    @NotNull(message = "champs vide")
    @Size(min = 5, message = "titre court")

    // Not Null de base de donnée
    @Column(nullable = false)
    private String categorie;

    @OneToMany(mappedBy = "categorie", orphanRemoval = true)
    @JsonIgnore
    private List<Quiz> quizs = new ArrayList<>();

   
}
