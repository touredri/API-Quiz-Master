package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Service.UtilisateurService;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateur")
public class UtilisateurController {


    @Autowired // Injection de dependance
    UtilisateurService utilisateurService; // Un variable de type UtilisateurService

    /*@PostMapping("/ajouter")
    public Utilisateur ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurService.creerUtilisateur(utilisateur);
    }*/

    @PostMapping("/ajouter")
    public Object ajouterUtilisateur(@RequestBody Utilisateur utilisateur){
        Utilisateur verifUtilisateur = utilisateurService.creerUtilisateur(utilisateur);
        if (verifUtilisateur != null) {
            return verifUtilisateur;
        } else {
            return "Utilisateur existe déja !";
        }
    }

    @PostMapping("/connexion")
    public Object connexion(@RequestParam("email") String email, @RequestParam("mot_de_passe") String mot_de_passe) {
        Utilisateur verifUtilisateur = utilisateurService.connectionUtilisateur(email, mot_de_passe);
        if (verifUtilisateur != null) {
            return verifUtilisateur;
        } else {
            return "Ce compte n'existe pas !";
        }
    }

    @GetMapping("/list")
    public List<Utilisateur> allUsers(){
        return utilisateurService.listUtilisateurs();
    }

    @PutMapping("/modifier")
    public  Object modifierUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur verifUtilisateur = utilisateurService.modifierUtilisateur(utilisateur);
        if (verifUtilisateur != null) {
            return verifUtilisateur;
        } else {
            return "Utilisateur n'existe pas !";
        }
    }

   @DeleteMapping("/supprimer")
    public String supprimerUtilisateur(@RequestBody Utilisateur utilisateur) {


        String message = utilisateurService.supprimeUtilisateur(utilisateur);
        if (message.equals("Succès")) {
            return "Utilisateur Supprimer avec succès";
        } else {
            return "Utilisateur n'existe pas !";
        }
    }




}
