package com.odk3.projet_tp_api.Service;

import com.odk3.projet_tp_api.Repository.QuestionRepository;
import com.odk3.projet_tp_api.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public Question createQuestion(Question question){

        if (questionRepository.findQuestionByContenueAndUtilisateurAndQuiz(question.getContenue(), question.getUtilisateur(), question.getQuiz()) == null){
            return questionRepository.save(question);
        }else
            return null;
    }

    public Question updateQuestion(Question question){

        if(questionRepository.findQuestionByIdQuestionAndUtilisateur(question.getIdQuestion(),question.getUtilisateur()) != null){
            return questionRepository.save(question);
        }else
            return null;
    }

    public List<Question> getAllQuestions(){
        return questionRepository.findAll();
    }

    public String deleteQuestion(Question question){

        if(questionRepository.findQuestionByIdQuestionAndUtilisateur(question.getIdQuestion(),question.getUtilisateur()) != null){
            questionRepository.delete(question);
            return "succes";
        }else
            return "not found";
    }


}
