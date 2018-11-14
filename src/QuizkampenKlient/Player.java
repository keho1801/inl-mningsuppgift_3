package QuizkampenKlient;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int score;
    private int wins;
    
public Player(String name) {
    this.name = name;
}

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }
    
}
