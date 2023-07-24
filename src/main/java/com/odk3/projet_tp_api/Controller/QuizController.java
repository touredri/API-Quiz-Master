package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Service.QuizService;
import com.odk3.projet_tp_api.model.Quiz;
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
    public ResponseEntity<Object> modifierQuiz(Quiz quiz) {
        Quiz verifQuiz = quizService.modifierQuiz(quiz);
        if (verifQuiz != null) {
            return new ResponseEntity<>(verifQuiz, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("existe pas", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/list")
    public List<Quiz> quizList() {
        return quizService.quizList();
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity<String> suppimerQuiz(Quiz quiz) {
        String message = quizService.supprimerQuiz(quiz);
        if (message.equals("Succès")) {
            return new ResponseEntity<>("Supprimer avec Succès", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not FOUND", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/recherche")
    public List<Quiz> rechercheQuiz(@RequestParam("cleTitre") String cleTitre) {
        return quizService.rechercherQuiz(cleTitre);
    }

}
