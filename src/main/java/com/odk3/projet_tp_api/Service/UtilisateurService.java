package com.odk3.projet_tp_api.Service;

import com.odk3.projet_tp_api.Repository.UtilisateurRepository;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {

    // Pour acceder a la table utilisateur dans la base de donnée
    @Autowired // Injection de dependance
    UtilisateurRepository utilisateurRepository; // Un variable de type UtilisateurRepository

    // Portee , type de retour , nom de la fonction
    public Utilisateur creerUtilisateur(Utilisateur utilisateur){
        if (utilisateurRepository.findByEmail(utilisateur.getEmail()) == null) {

            utilisateurRepository.save(utilisateur);
            return utilisateurRepository.findByEmail(utilisateur.getEmail());

        } else {
            return null;
        }

    }

    public List<Utilisateur> listUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur modifierUtilisateur(Utilisateur utilisateur) {

        if (utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur()) != null){
            utilisateurRepository.save(utilisateur);
            return utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur());
        }
        else {
            return null;
        }

    }

    public String supprimeUtilisateur(Utilisateur utilisateur) {

        if (utilisateurRepository.findByIdUtilisateur(utilisateur.getIdUtilisateur()) != null) {
            utilisateurRepository.delete(utilisateur);
            return "Succès";
        } else {
            return "Utilisateur n'existe pas";
        }

    }

    public Utilisateur connectionUtilisateur(String email, String mon_de_passe) {
        if (utilisateurRepository.findByEmailAndMotDePasse(email, mon_de_passe) != null) {
            return utilisateurRepository.findByEmailAndMotDePasse(email, mon_de_passe);
        }else {
            return null;
        }

    }


}
