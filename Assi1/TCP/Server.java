import java.net.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
public class Server{
    private static ArrayList<ClientHandler> clients = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(4);
    public static void main(String args[]) throws IOException{
        ServerSocket socket = new ServerSocket(5000);
        try{
            while(true){
                Socket client = socket.accept();
                System.out.println("Connected");
                ClientHandler clientThread = new ClientHandler(client);
                clients.add(clientThread);
                pool.execute(clientThread);
            }
        }
        finally{
            socket.close();
        }
    }
}
