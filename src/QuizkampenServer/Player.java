package QuizkampenServer;

import java.net.Socket;

public class Player extends Thread {
    private String name;
    private Player opponent;
    private int score;
    private int wins;
    Socket socket;
    
public Player(String name, Socket socket) {
    this.name = name;
    this.socket = socket;
}

    public String getPlayerName() {
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

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getOpponent() {
        return opponent;
    }
    
}
