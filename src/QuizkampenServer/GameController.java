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
        //tar in alla frågor
        q.initializeQuestionDatabase();
        //shufflar listan för frågorna
        q.shuffleQuestionList();
        //läs in antal frågor/ronder från properties filen
        questionsInGame = q.getQuestionsInGame();
        
        //properties fil size = p
        
        int p = 0; 
        int i = 0;
        String [] Answer = new String[p];
        String correctAnswer = "";
        
        //skapa metod reutnera en bool för svar.
        
        for(Question e: questionsInGame){
            Answer = questionsInGame.get(i).getAnswers();
            correctAnswer = Answer[p];
            if(instrom == correctAnswer){
                
            }
            System.out.println(e);
            i++;
            p++;
        }
        
        //rätt svar innan shuffle, svar ligger på första plats.
        //String correctAnswer = Answer[p];
        
        //shufflar svaren i string[].
        Collections.shuffle(Arrays.asList(Answer));
        
        //skickar frågorna till klienterna och svaren shufflade.
        
        //jämför svar med rättsvar
        if(instrom == correctAnswer)
        
        
        }
        
    }


