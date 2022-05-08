import java.net.*;
import java.io.*;
public class UDPClient{
public static void main(String[] args) throws Exception {
/* * send to the server */
//1. Define the server address, port number, Data package
InetAddress address = InetAddress.getByName("127.0.0.1");
int port = 8800;
BufferedReader keyboard= new BufferedReader(new InputStreamReader(System.in));
String message;
System.out.println("Enter the degrees : ");
message = keyboard.readLine();
byte[] data = message.getBytes();
//2. Create a data package, including Message sent
DatagramPacket packet = new DatagramPacket(data, data.length, address, port);//3. Create DatagramSocket object
DatagramSocket socket = new DatagramSocket();

//4. Send data packet to the server
System.out.println("The client is sending data to the server");
socket.send(packet);
/* * Receive server-side data */
//1. Create a data packet for receiving response data
byte[] data2 = new byte[1024];
DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
//2. Receive data
socket.receive(packet2);
//3. Read data
String reply = new String(data2);
System.out.println("Client starts receiving data");
System.out.println("Radians : "+reply);
//4. Close the resource
socket.close();
}
}
