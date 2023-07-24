package com.odk3.projet_tp_api.Repository;

import com.odk3.projet_tp_api.model.Quiz;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

    public Quiz findByTitreAndUtilisateur(String titre, Utilisateur utilisateur);

    public  Quiz findByIdQuizAndUtilisateur(int id, Utilisateur utilisateur);

    public List<Quiz> findByTitreContains(String cleTitre);
}
