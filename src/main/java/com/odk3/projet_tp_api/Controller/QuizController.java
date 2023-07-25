package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Service.QuizService;
import com.odk3.projet_tp_api.model.Quiz;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterQuiz(@RequestBody Quiz quiz) {
        Quiz verifQuiz = quizService.creerQuiz(quiz);
        if (verifQuiz != null) {
            return new ResponseEntity<>(verifQuiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("existe", HttpStatus.OK);
        }
    }

    @PutMapping("/modifier")
    public ResponseEntity<Object> modifierQuiz(@RequestBody Quiz quiz) {
        Quiz verifQuiz = quizService.modifierQuiz(quiz);
        if (verifQuiz != null) {
            return new ResponseEntity<>(verifQuiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("existe pas", HttpStatus.NOT_FOUND);
        }
        //return new ResponseEntity<>(quizService.modifierQuiz(quiz), HttpStatus.OK);
    }

    @GetMapping("/list")
    public List<Quiz> quizList() {
        return quizService.quizList();
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity<String> suppimerQuiz(@RequestBody Quiz quiz) {
        String message = quizService.supprimerQuiz(quiz);
        if (message.equals("Succès")) {
            return new ResponseEntity<>("Supprimer avec Succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Recherche des quiz à travers un titre")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",description = "Quiz trouver",content = {
                    @Content(mediaType = "application/json",schema = @Schema(implementation = Quiz.class))
            }),
            @ApiResponse(responseCode = "400",description = "Mauvaise requete", content = @Content),
            @ApiResponse(responseCode = "404",description = "Quiz non trouver", content = @Content),
            @ApiResponse(responseCode = "500",description = "Erreur server", content = @Content)
    })
    @GetMapping("/recherche")
    public ResponseEntity<List<Quiz>> rechercheQuiz(@Parameter(description = "Titre du quiz à rechercher") @RequestParam("cleTitre") String cleTitre) {
        return new ResponseEntity<>(quizService.rechercherQuiz(cleTitre),HttpStatus.OK);
    }

}
