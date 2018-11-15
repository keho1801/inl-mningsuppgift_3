package QuizkampenServer;

import java.io.Serializable;
import java.util.List;

public class Question implements Serializable {
    private String question;
    private String correctAnswer;
    private String category;
    private List<String> answers;
    
    public Question(String question, String correctAnswer, List<String> answers, String category) {
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.answers = answers;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getQuestion() {
        return question;
    }
    
    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
