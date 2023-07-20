package com.odk3.projet_tp_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Participer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int idParticiper;

    @Column(nullable = false)
    private int score;
}
