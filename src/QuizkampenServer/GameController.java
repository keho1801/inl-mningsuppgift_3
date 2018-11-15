package QuizkampenServer;

import QuizkampenServer.Question;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GameController {
    private List<Question> questionsInGame = new ArrayList<>();
      
            
    public GameController() {
        QuestionUtil q = new QuestionUtil();
        q.initializeQuestionDatabase();
        q.shuffleQuestionList();
        //läs in antal frågor/ronder från properties filen
        questionsInGame = q.getQuestionsInGame();
        
        String [] Answer = questionsInGame.get(0).getAnswers();
        
        //rätt svar innan shuffle, svar ligger på första plats.
        String correctAnswer = Answer[0];
        //shufflar svaren.
        Collections.shuffle(Arrays.asList(Answer));
        
        //skickar frågorna till klienterna
        
        
        
        }
        
    }


