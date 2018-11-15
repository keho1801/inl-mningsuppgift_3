package QuizkampenServer;

import QuizkampenKlient.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameController {
    private List<Question> questionsDatabase = new ArrayList<>();
    private List<Question> questionsInGame = new ArrayList<>();
    int numberOfQuestions;
            
    public GameController(int nrOfQuestionsInGame) {
        this.numberOfQuestions = nrOfQuestionsInGame;
        
//        questionsDatabase.add(new Question("Hur långt är ett snöre?", "3.1415"));
//        questionsDatabase.add(new Question("Svara ja.", "ja"));
//        questionsDatabase.add(new Question("Vem är statsminister?", "stefan lövèn"));
//        questionsDatabase.add(new Question("Stämde fråga 1?", "nej"));
//        questionsDatabase.add(new Question("Vad kommer efter 9?", "10"));
//        questionsDatabase.add(new Question("Ska det finnas ananas på pizza?", "nej"));
//        questionsDatabase.add(new Question("Fisk eller...?", "fågel"));
//        questionsDatabase.add(new Question("Vad är motsatsen till över?", "under"));
//        questionsDatabase.add(new Question("Vem ler på en känd tavla?", "mona-lisa"));
        
        Collections.shuffle(questionsDatabase);
        
        for (int i = 0; i < nrOfQuestionsInGame; i++) {
            questionsInGame.add(questionsDatabase.get(i));
            questionsDatabase.remove(i);
        }
        
    }
}
