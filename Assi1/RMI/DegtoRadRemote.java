import java.rmi.*;
import java.rmi.server.*;
public class DegtoRadRemote extends UnicastRemoteObject implements DegtoRad{
DegtoRadRemote()throws RemoteException{
super();
}
public double toRad(double deg)
{
return Math.toRadians(deg);
}
}
