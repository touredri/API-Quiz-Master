package com.odk3.projet_tp_api.Repository;

import com.odk3.projet_tp_api.model.Question;
import com.odk3.projet_tp_api.model.Quiz;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Question findQuestionByIdQuestionAndUtilisateur(int id, Utilisateur utilisateur);
    Question findByIdQuestion(int id);
    Question findQuestionByContenueAndUtilisateurAndQuiz(String contenue, Utilisateur utilisateur, Quiz quiz);

}
