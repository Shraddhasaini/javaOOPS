import java.rmi.*;
import java.rmi.server.*;
public class RIImplement extends UnicastRemoteObject implements RemoteInterface{
RIImplement() throws RemoteException{
super();
}
public int add(int x, int y){
return x+y;
}
}