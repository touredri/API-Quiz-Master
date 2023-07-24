package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Repository.ReponseRepository;
import com.odk3.projet_tp_api.Service.ReponseService;
import com.odk3.projet_tp_api.model.Question;
import com.odk3.projet_tp_api.model.Reponse;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reponse")
public class ReponseController {

    @Autowired // Injection de depandence
    ReponseService reponseService; // Un variable de type UtilisateurService

    @Autowired
    ReponseRepository reponseRepository;

    @PostMapping ("/ajouter")
    public ResponseEntity<Object> ajouterReponse(@RequestBody Reponse reponse) {
        Reponse verifReponse = reponseService.creerReponse(reponse);
        if (verifReponse != null) {
            if (reponseRepository.countByQuestion(verifReponse.getQuestion()) >= 4){
                return new ResponseEntity<>("nombre de reponse atteint", HttpStatus.OK);
            }else{
                return new ResponseEntity<>(verifReponse, HttpStatus.OK) ;
            }
        } else {
            return new ResponseEntity<>("Reponse existe déjà", HttpStatus.OK);
        }
    }

    @PutMapping("/modifier")
    public ResponseEntity<Object> modifierReponse(@RequestBody Reponse reponse) {
        Reponse verifReponse = reponseService.modiferReponse(reponse);
        if (verifReponse != null) {
            return new ResponseEntity<>(verifReponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Modification succès", HttpStatus.OK);
        }
    }

    @GetMapping("list")
    public List<Reponse> listQuestion(){
        return reponseService.reponses();
    }

    @DeleteMapping("/supprimer")
    public  ResponseEntity<String> supprimerReponse(Reponse reponse){
        String message = reponseService.supprimerReponse(reponse);
        if (message.equals("Succès")) {
            return new ResponseEntity<>("Suppression avec Succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cette reponse existe pas", HttpStatus.OK);
        }
    }

}
