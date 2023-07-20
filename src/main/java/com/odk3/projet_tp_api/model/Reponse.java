package com.odk3.projet_tp_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reponse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(nullable = false)
    private int idReponse;

    @Column(nullable = false)
    private  String contenue;

    @Column(nullable = false)
    private boolean correct;
}
