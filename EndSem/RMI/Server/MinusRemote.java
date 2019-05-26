import java.rmi.*;
import java.rmi.server.*;
public class MinusRemote extends UnicastRemoteObject implements Minus{
MinusRemote()throws RemoteException{
super();}
public int sub(int a,int b){return a-b;}
}