import java.rmi.*;
import java.util.Scanner;
public class RmiClient{
public static void main(String args[])
{
try{
Scanner sc = new Scanner(System.in);
System.out.println("Enter degrees : ");
double deg = sc.nextDouble();
DegtoRad stub= (DegtoRad)Naming.lookup("rmi://localhost:5000/conv");
System.out.println(stub.toRad(deg));
}
catch(Exception e){
System.out.println(e);
}
}
}
