import java.rmi.*;
import java.rmi.registry.*;
public class Myserver{
public static void main(String args[]){  
try{  
Minus stub=new MinusRemote();  
Naming.rebind("rmi://localhost:5000/sonoo",stub);  
}catch(Exception e){System.out.println(e);}  
}  
}