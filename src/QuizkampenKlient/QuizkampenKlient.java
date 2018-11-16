package QuizkampenKlient;

import Models.Question;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class QuizkampenKlient {
    
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        
        try (Socket socketToServer = new Socket(InetAddress.getLocalHost(), 12345);
                PrintWriter out = new PrintWriter(socketToServer.getOutputStream(), true);
                ObjectInputStream in = new ObjectInputStream(socketToServer.getInputStream());
                ){
            
            Object fromServer;
            String fromUser = "Anna";
            
            out.println(fromUser);
            
            while ((fromServer = in.readObject()) != null){
                if (((Question) fromServer).getQuestion() == null){
                    System.out.println("Välkommen " + fromUser);
                } else {
                    System.out.println(((Question) fromServer).getQuestion());
                    //Sätter frågan och knapparna
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
