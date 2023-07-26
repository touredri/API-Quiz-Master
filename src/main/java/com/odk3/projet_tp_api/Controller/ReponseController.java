package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Repository.ReponseRepository;
import com.odk3.projet_tp_api.Service.ReponseService;
import com.odk3.projet_tp_api.model.Question;
import com.odk3.projet_tp_api.model.Quiz;
import com.odk3.projet_tp_api.model.Reponse;
import com.odk3.projet_tp_api.model.Utilisateur;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
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


    @Operation(summary = "Ajouter une reponse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Reponse ajouter",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reponse.class))
            }),
            @ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @ApiResponse(responseCode = "409",description = "reponse exist déjà", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PostMapping ("/ajouter")
    public ResponseEntity<Object> ajouterReponse(@Valid @RequestBody Reponse reponse) {
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


    @Operation(summary = "Modifier une reponse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Reponse modifier",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reponse.class))
            }),
            @ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @ApiResponse(responseCode = "404",description = "Reponse n'existe pas", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @PutMapping("/modifier")
    public ResponseEntity<Object> modifierReponse(@Valid @RequestBody Reponse reponse) {
        Reponse verifReponse = reponseService.modiferReponse(reponse);
        if (verifReponse != null) {
            return new ResponseEntity<>(verifReponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Modification succès", HttpStatus.OK);
        }
    }


    @Operation(summary = "Renvoie la liste des reponses")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "List renvoyer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reponse.class))
            }),
            @ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @ApiResponse(responseCode = "204",description = "List vide", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("list")
    public List<Reponse> listQuestion(){
        return reponseService.reponses();
    }


    @Operation(summary = "Supprimer une reponse")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Reponse supprimer",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Reponse.class))
            }),
            @ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @ApiResponse(responseCode = "404",description = "Utilisateur introuvable", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @DeleteMapping("/supprimer")
    public  ResponseEntity<String> supprimerReponse(@Valid @RequestBody Reponse reponse){
        String message = reponseService.supprimerReponse(reponse);
        if (message.equals("Succès")) {
            return new ResponseEntity<>("Suppression avec Succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cette reponse existe pas", HttpStatus.OK);
        }
    }

}
