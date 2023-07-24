package com.odk3.projet_tp_api.Service;

import com.odk3.projet_tp_api.Repository.QuizRepository;
import com.odk3.projet_tp_api.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    public Quiz creerQuiz(Quiz quiz) {
        if (quizRepository.findByTitreAndUtilisateur(quiz.getTitre(), quiz.getUtilisateur()) == null) {
            return quizRepository.save(quiz);
        } else {
            return null;
        }
    }

    public Quiz modifierQuiz(Quiz quiz) {
        if (quizRepository.findByIdQuizAndUtilisateur(quiz.getIdQuiz(), quiz.getUtilisateur()) != null) {
            return quizRepository.save(quiz);
        } else {
            return null;
        }
    }

    public List<Quiz> quizList() {
        return quizRepository.findAll();
    }

    public String supprimerQuiz(Quiz quiz) {
        if (quizRepository.findByIdQuizAndUtilisateur(quiz.getIdQuiz(), quiz.getUtilisateur()) != null) {
           quizRepository.delete(quiz);
           return "Succès";
        } else {
            return "not found";
        }
    }

    public List<Quiz> rechercherQuiz(String cleTitre) {
        if (quizRepository.findByTitreContains(cleTitre) != null) {
            return quizRepository.findByTitreContains(cleTitre);
        } else {
            return null;
        }
    }
}
