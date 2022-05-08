import java.net.*;
import java.io.*;
public class Client{
    private Socket socket =null;
    private PrintWriter out = null;
    public Client(String address,int port) throws IOException
    {
        socket = new Socket(address,port);
        System.out.println("Connected");
        out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new
        InputStreamReader(socket.getInputStream()));
        String message;
        System.out.println(">");
        message = keyboard.readLine();
        out.println(message);
        String rad = in.readLine();
        System.out.println(rad);
        out.close();
        keyboard.close();
        socket.close();
    }
    public static void main(String args[]) throws IOException
    {
    Client client = new Client("127.0.0.1",5000);
    }
}
