/*
 */
package QuizkampenServer;

import Models.Player;
import Models.Question;
import java.io.BufferedReader;
import QuizkampenKlient.*;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author kenny
 */
public class QuizkampenServer {

    public static void main(String[] args) throws Exception {

            ServerSocket serverSocket = new ServerSocket(12345);
            
            try{
                while (true) {
                GameController game = new GameController();

                Player playerX = new Player(serverSocket.accept(), "PlayerX", game);

                Player playerY = new Player(serverSocket.accept(), "PlayerY", game);
                
                game.setPlayers(playerX, playerY);
                playerX.setOpponent(playerY);
                playerY.setOpponent(playerX);
                game.start();
                
            }
            }finally{
                serverSocket.close();
            }
        
        }

    }
