package Models;

import java.io.Serializable;

public class Question implements Serializable {
    static final long serialVersionUID = 42L;
    public String question;
    private String answer;
    
    public Question(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }
}
