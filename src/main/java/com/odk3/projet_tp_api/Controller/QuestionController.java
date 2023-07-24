package com.odk3.projet_tp_api.Controller;

import com.odk3.projet_tp_api.Repository.QuestionRepository;
import com.odk3.projet_tp_api.Service.QuestionService;
import com.odk3.projet_tp_api.model.Question;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @PostMapping("/ajouter")
    public ResponseEntity<Object> ajouterQuestion(@RequestBody Question question){
        Question questionVerif = questionService.createQuestion(question);
        if (questionVerif != null){
            return new ResponseEntity<>(questionVerif, HttpStatus.OK);
        }else
            return new ResponseEntity<>("Question existe déjà", HttpStatus.OK);
    }

    @PutMapping("/modifier")
    public ResponseEntity<Object> modifierQuestion(@RequestBody Question question){

        Question questionVerif = questionService.updateQuestion(question);
        if (questionVerif != null){
            return new ResponseEntity<>(questionVerif, HttpStatus.OK);
        }else
            return new ResponseEntity<>("Question n'existe pas", HttpStatus.OK);
    }

    @GetMapping("list")
    public List<Question> listQuestion(){
        return questionService.getAllQuestions();
    }

    @DeleteMapping("/supprimer")
    public ResponseEntity<String> supprimerQuestion(@RequestBody Question question){

        String message = questionService.deleteQuestion(question);
        if (message.equals("succes")){
            return new ResponseEntity<>("Question supprimer avec succes",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Question not found",HttpStatus.OK);
        }
    }


}
