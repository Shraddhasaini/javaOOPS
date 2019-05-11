import java.rmi.*;
import java.util.*;
public class MainClient{
public static void main(String args[]){
try{
RemoteInterface st=(RemoteInterface)Naming.lookup("rmi://localhost:1020/add");
Scanner sc = new Scanner(System.in);
int x,y;
System.out.println("enter two values for addition");
x=sc.nextInt();
y=sc.nextInt();
System.out.println("The sum is of " +x +"and " +y +"is: " +st.add(x,y));
}
catch(Exception e){
System.out.println(e);
}
}
}