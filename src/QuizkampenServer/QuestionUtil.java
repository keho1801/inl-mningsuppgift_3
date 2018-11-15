package QuizkampenServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionUtil {
    private List<Question> questionsDatabase = new ArrayList<>();
    private List<Question> questionsInGame = new ArrayList<>();
    String[] category = { "Biologi", "Sport och fritid", "Kultur och musik", "Vetenskap" };
    int nrOfQuestionsInGame = 4;
    
    public QuestionUtil() {
    }
    
    public void initializeQuestionDatabase() {
        String[] q1 = { "Alexander Graham Bell", "Guglielmo Marconi", "Nicola Tesla", "Teletubbies" };
        questionsDatabase.add(new Question("Vem uppfann telefonen?", q1, category[3]));
        
        String[] q2 = { "Ja", "Nej", "Tveksamt", "Under utredning" };
        questionsDatabase.add(new Question("Ska det finnas ananas på pizza?", q2, category[3]));
        
        String[] q3 = { "3.14", "15cm", "3kg", "null" };
        questionsDatabase.add(new Question("Hur långt är ett snöre?", q3, category[0]));
        
        String[] q4 = { "Stefan Lövèn", "Birgitta Ohlsson", "Per Orskarsson", "ALice Bah-Kunhke" };
        questionsDatabase.add(new Question("Vem är statsminister?", q4, category[3]));
        
        String[] q5 = { "Mona-Lisa", "Mona Sahlin", "Monet", "Mon Cheri" };
        questionsDatabase.add(new Question("Vem ler på en känd tavla?", q5, category[2]));
        
        String[] q6 = { "Usasin Bolt", "Ben Johnson", "Michael Johnson", "Tyson Gay" };
        questionsDatabase.add(new Question("Vem springer snabbast?", q6, category[1]));
        
    }
    
    public void shuffleQuestionList() {
        Collections.shuffle(questionsDatabase);
    }
    
    public List<Question> currentGameQuestions() {
        for (int i = 0; i < nrOfQuestionsInGame; i++) {
            questionsInGame.add(questionsDatabase.get(i));
            questionsDatabase.remove(i);
        }
        return questionsInGame;
    }

    public List<Question> getQuestionsDatabase() {
        return questionsDatabase;
    }

    public List<Question> getQuestionsInGame() {
        return questionsInGame;
    }

}
