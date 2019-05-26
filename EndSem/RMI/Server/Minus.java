import java.rmi.*;
public interface Minus extends Remote{
public int sub(int a, int b) throws RemoteException;
}