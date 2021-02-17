package ClientBackend;

import supports.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Client extends Thread{
    AtomicReference<String> inputString = new AtomicReference<>("");
    private AtomicReference<Package> thePackage = new AtomicReference<>();
    AtomicBoolean serverIsReady = new AtomicBoolean(true);
    // Socket socket = new Socket("localhost", 12345);   //  locally use
    Socket socket = new Socket("34.96.223.235", 12345);      //  adopted only when online server is on

    Boolean login = false;
    InputStreamReader socketSR = new InputStreamReader(socket.getInputStream());
    BufferedReader socketBr = new BufferedReader(socketSR);
    
    PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
    JsonDealer jsonDealer;

    public Client() throws IOException {
        jsonDealer = new JsonDealer(this);
    }

    public void beforeLogin() throws Exception {
        while (login == false){
            String val = inputString.get();
            if(val.equals("") == false){
                // sending user request
                interaction();
            }
        }
    }

    public void interaction() throws Exception{
        serverIsReady.set(false);
        printWriter.println(inputString);
        printWriter.flush();
        String s = socketBr.readLine();
        System.out.println("server : " + s);
        Package aPackage = jsonDealer.mainParser(s);
        thePackage.set(aPackage);
        inputString.set("");
        serverIsReady.set(true);
    }

    @Override
    public void run() {
        jsonDealer = new JsonDealer(this);
        try {
            System.out.println("connected");
            beforeLogin();
            System.out.println("successfully login");
            while (true){
                String val = inputString.get();
                if(val.equals("") == false){
                    interaction();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendRequest(String request) throws Exception{
        if(serverIsReady.get()){
            inputString.set(request);
        }else {
            wait();
        }
    }

    public Package getPackage() throws Exception{
        while (thePackage.get() == null){

        }
        Package aPackage = thePackage.get();
        thePackage.set(null);
        return aPackage;
    }


    public void loginTest() throws Exception{
        sendRequest(jsonDealer.getJsonLogin("pkdyc","123456").toString());
        Package aPackage = getPackage();
        if (aPackage.status != Status.LOGIN_SUCCESSES){
            System.out.println("failed");
        }else {
            System.out.println("pass");
        }
    }

    public void loginTestEmpty() throws Exception{
        sendRequest(jsonDealer.getJsonLogin("pkdkl","123").toString());
        Package aPackage = getPackage();
        if (aPackage.status != Status.LOGIN_SUCCESSES){
            System.out.println("failed");
        }else {
            System.out.println("pass");
        }
    }


    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.start();
    }

    public static Client mainEntrance() {
        Client client = null;
        try {
            client = new Client();
        } catch (IOException e) {
            e.printStackTrace();
        }
        client.start();
        return client;
    }
}
