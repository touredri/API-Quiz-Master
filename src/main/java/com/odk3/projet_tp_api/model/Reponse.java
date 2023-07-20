package com.odk3.projet_tp_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Reponse {
    @Id

    // Pour mettre le type en auto incremente
    @GeneratedValue(strategy = GenerationType.AUTO)

    // Not Null de base de donnée
    @Column(nullable = false)
    private int idReponse;

    @Lob
    @Size(min = 5, message = "contenue court")
    // Not Null de base de donnée
    @Column(nullable = false)
    private  String contenue;

    // Not Null de base de donnée
    @Column(nullable = false)
    private boolean correct;
}
