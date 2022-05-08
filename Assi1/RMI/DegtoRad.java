import java.rmi.*;
public interface DegtoRad extends Remote{
public double toRad(double deg)throws RemoteException;
}
