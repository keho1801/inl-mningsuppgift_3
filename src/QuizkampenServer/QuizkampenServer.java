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
                ServerSideGame game = new ServerSideGame();
                Player playerX 
                        = new Player(listener.accept(), 'X', game);
                Player playerO 
                        = new Player(listener.accept(), 'O', game);
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

