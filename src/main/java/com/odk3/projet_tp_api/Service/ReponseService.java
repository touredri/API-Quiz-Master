package com.odk3.projet_tp_api.Service;

import com.odk3.projet_tp_api.Repository.ReponseRepository;
import com.odk3.projet_tp_api.model.Reponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReponseService {

    // Pour acceder a la table utilisateur dans la base de donnée
    @Autowired // Injection de depandence
    ReponseRepository reponseRepository; // Un variable de type ReponseRepository

    // Portee , type de retour , nom de la fonction

    public Reponse creerReponse(Reponse reponse) {
        if (reponseRepository.findByContenueAndQuestion(reponse.getContenue(), reponse.getQuestion()) == null) {
            return reponseRepository.save(reponse);
        } else {
            return null;
        }
    }

    public Reponse modiferReponse(Reponse reponse) {
        if (reponseRepository.findByIdReponseAndUtilisateur(reponse.getIdReponse(), reponse.getUtilisateur()) != null) {
            return reponseRepository.save(reponse);
        } else {
           return null;
        }
    }

    public List<Reponse> reponses() {
        return reponseRepository.findAll();
    }

    public String supprimerReponse(Reponse reponse) {
        if (reponseRepository.findByIdReponseAndUtilisateur(reponse.getIdReponse(), reponse.getUtilisateur()) != null) {
            reponseRepository.delete(reponse);
            return "Succès";
        } else {
            return "not found";
        }
    }
}
