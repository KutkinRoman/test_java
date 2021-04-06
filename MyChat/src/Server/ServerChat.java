package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerChat {
    private Vector<ClientHandler> users;

    public ServerChat() {

        users = new Vector<>();
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            AuthSetvice.connect();
            serverSocket = new ServerSocket(8000);
            System.out.println("Server start");

//            System.out.println("result from DB: " + AuthSetvice.getNicknameByLoginAndPassword("log1", "pass1"));

            while (true){
                socket = serverSocket.accept();
                System.out.println("Client connected\n" +
                        socket.getInetAddress());

             new ClientHandler(this, socket);
            }

        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        AuthSetvice.dicconnect();


    }

    public void subscribe(ClientHandler client){
        users.add(client);
    }

    public void unsubscribe(ClientHandler client){
        users.remove(client);
    }

    public void broadcastMSG(String str){
        for (ClientHandler c: users
             ) {
            c.sendMSG(str);
        }
    }
}