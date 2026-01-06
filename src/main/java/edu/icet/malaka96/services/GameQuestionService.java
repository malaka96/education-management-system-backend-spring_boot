package edu.icet.malaka96.services;

import edu.icet.malaka96.models.GameQuestion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameQuestionService {

    public List<GameQuestion> getQuestions(){
        return null;
    }

    public void addQuestion(GameQuestion gameQuestion){
        //
    }

    public boolean updateQuestion(String id, GameQuestion gameQuestion){
        return true;
    }

    public boolean deleteQuestion(String id){
        return true;
    }

}
