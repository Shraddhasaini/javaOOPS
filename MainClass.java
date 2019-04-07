class One{ private int x;
	public void fun1(){
	System.out.println("Parent class One " +x);
 }
	public int getx(){
 	return x;
}
	public void setx(int newx){
	x = newx;
}
}
class Two extends One{
	public void fun1(){
	System.out.println("Child class Two");
	One obj1 = new One();
	obj1.setx(10);
	obj1.fun1();
	}
}
public class MainClass extends Two{
	void fun(){
	System.out.println("Main class");
	}
	public static void main(String args[]){
	MainClass obj = new MainClass();
	obj.fun1();
	obj.fun();
 }
}