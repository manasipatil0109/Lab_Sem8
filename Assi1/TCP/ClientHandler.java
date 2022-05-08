import java.net.*;
import java.io.*;
public class ClientHandler implements Runnable{
    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    public ClientHandler(Socket clientSocket) throws IOException
    {
        this.client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);
    }
    @Override
    public void run()
    {
        String message="";
        try
        {
            message= in.readLine();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
        System.out.println(message);
        int deg = Integer.parseInt(message);
        double rad = Math.toRadians(deg);
        System.out.println(rad);
        String output = Double.toString(rad);
        out.println(output);
        try
        {
            in.close();
            out.close();
            client.close();
        }
        catch(IOException i)
        {
            System.out.println(i);
        }
    }
}
