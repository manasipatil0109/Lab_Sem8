import java.net.*;
public class UDPServer{
public static void main(String[] args) throws Exception {
//1. Create server-side DatagramSocket, specify port
DatagramSocket socket = new DatagramSocket(8800);
//2. Create a data packet to receive the data sent by the client
byte[] data = new byte[1024];
DatagramPacket packet = new DatagramPacket(data, data.length);
//3. Receive data sent by the client
System.out.println("------ The server has been started, waiting for client data ----- -");
//loop monitoring
while(true){
socket.receive(packet);//This method will block until a data packet is received
//open a thread to communicate with the client
UDPServerThread thread = new UDPServerThread(data,socket, packet);
thread.start();
}//4. Close the resource
//socket.close();
}
}
