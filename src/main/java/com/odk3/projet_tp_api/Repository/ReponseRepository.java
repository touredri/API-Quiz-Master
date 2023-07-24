package com.odk3.projet_tp_api.Repository;

import com.odk3.projet_tp_api.model.Question;
import com.odk3.projet_tp_api.model.Reponse;
import com.odk3.projet_tp_api.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReponseRepository extends JpaRepository<Reponse,Integer> {

    public Reponse findByContenueAndQuestion(String contenue, Question question);

    public  Reponse findByIdReponseAndUtilisateur(int id, Utilisateur utilisateur);
}
