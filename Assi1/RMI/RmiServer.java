import java.rmi.*;
import java.rmi.registry.*;
public class RmiServer{
public static void main(String args[])
{
try{
DegtoRad stub = new DegtoRadRemote();
Naming.rebind("rmi://localhost:5000/conv",stub);
}
catch(Exception e){System.out.println(e);}
}
}
