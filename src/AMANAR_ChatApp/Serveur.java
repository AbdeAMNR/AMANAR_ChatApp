package AMANAR_ChatApp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbdeAMNR
 */
public class Serveur {

    private ServerSocket sktServer;
    private Socket sktServiceClient;
    private DataOutputStream outputToServer;
    private BufferedReader inputFromServer;

    public Serveur() {
        try {
            sktServer = new ServerSocket(1002);
            sktServiceClient = sktServer.accept();
            outputToServer = new DataOutputStream(sktServiceClient.getOutputStream());
            inputFromServer = new BufferedReader(new InputStreamReader(sktServiceClient.getInputStream()));
            String msgClient = inputFromServer.readLine();
            System.out.println(" message Client : " + msgClient);
            outputToServer.writeBytes("message serveur \n");
        } catch (IOException ex) {
            Logger.getLogger(Serveur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Serveur serveur = new Serveur();
    }
}
