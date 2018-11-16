/*
 */

package QuizkampenServer;

import java.net.ServerSocket;

/**
 *
 * @author kenny
 */
public class QuizkampenServer {
    public static void main(String[] args) throws Exception {
        ServerSocket listener = new ServerSocket(8901);
        System.out.println("Tic Tac Toe Server is Running");
        try {
            while (true) {
                Player playerX 
                        = new Player("x", listener.accept());
                Player playerO 
                        = new Player("o", listener.accept());
                
                GameController game = new GameController();
                playerX.setOpponent(playerO);
                playerO.setOpponent(playerX);
                playerX.start();
                playerO.start();
            }
        } finally {
            listener.close();
        }
    }
}

