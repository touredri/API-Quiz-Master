package com.odk3.projet_tp_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Utlisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private int idUtilisateur;

    @NotNull(message = "Chemps vide")
    @Size(min = 2, message = "nom court")
    @Column(nullable = false)
    private String nom;

    @NotNull(message = "Champs vide")
    @Size(min = 2,message = "veuillez saisir un noms correcte")
    @Column(nullable = false)
    private String prenom;

    @NotNull(message = "Chemps vide")
    @Email(message = "email correct")
    @Column(nullable = false)
    private String email;

    @NotNull(message = "Chemps vide")
    @Column(nullable = false)
    private String motDePasse;
}
