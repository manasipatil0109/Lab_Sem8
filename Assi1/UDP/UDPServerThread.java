import java.net.*;
import java.io.*;
public class UDPServerThread extends Thread{
DatagramSocket socket = null;
byte[] data = null;
int port;
InetAddress address;
public UDPServerThread(byte[] data,DatagramSocket socket,DatagramPacket packet) {
this.socket = socket;
this.data = data;
address = packet.getAddress();
port = packet.getPort();
}
//Method to be executed by the thread
public void run(){
//4. Read data
System.out.println("Thread start");
String info = new String(data);
System.out.println(info);
/* * Respond to the client */
int deg = (((int)info.charAt(0))-48)*10+ ((int)info.charAt(1))-48;
double rad = Math.toRadians(deg);
String output = Double.toString(rad);
byte[] data2 = output.getBytes();

DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
//3. Respond to client
try {
socket.send(packet2);
System.out.println("The server-side data has been sent");
} catch (IOException e) {
//TODO Auto-generated catch block
e.printStackTrace();
}finally{
}}
}
