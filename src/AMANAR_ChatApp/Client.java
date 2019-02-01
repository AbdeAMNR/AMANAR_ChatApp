package AMANAR_ChatApp;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbdeAMNR
 */
public class Client {

    private int portNumber = 1002;
    private String ipNumber = "127.0.0.1";
    private Socket sktClient = null;
    private DataOutputStream outputToServer;
    private BufferedReader inputFromServer;
    private String msgClient, msgServer;

    public Client() {
        try {
            sktClient = new Socket(ipNumber, portNumber);
            outputToServer = new DataOutputStream(sktClient.getOutputStream());
            inputFromServer = new BufferedReader(new InputStreamReader(sktClient.getInputStream()));
            outputToServer.writeBytes("message client \n");
            msgServer = inputFromServer.readLine();
            System.out.println(" message Serveur : " + msgServer);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}
