import java.rmi.*;  
public class MyClient{  
public static void main(String args[]){  
try{  
Minus stub=(Minus)Naming.lookup("rmi://localhost:5000/sonoo");  
System.out.println(stub.sub(34,4));  
}catch(Exception e){}  
}  
}  