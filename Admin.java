class Scs{
	public String name(){
	return name; }
	private int age;
	private int sal;

	public int getage(){
	return age;
 }
	public int getsal(){
	return sal;
 }
	public void setage(int newage){
	age = newage;
 }
	public void setsal(int newsal){
	sal = newsal;
 }
}

class D1 extends Scs{
	public void FacD1(){
	Scs obj1 = new Scs();
	obj1.name("Shraddha");
	obj1.setage(35);
	obj1.setsal(100000);
	System.out.println("Department: D1 Name: " + obj1.name() + "Age: " + obj1.getage() + "sal: " + obj1.getsal());
 }
}

class D2 extends D1{
	public void FacD2(){
	Scs obj2 = new Scs();
	obj2.name("Saksham");
	obj2.setage(34);
	obj2.setsal(200000);
	System.out.println("Department: D2 Name: " + obj2.name() + "Age: " + obj2.getage() + "sal: " + obj2.getsal());
 }
}

class D3 extends D2{
	public void FacD3(){
	Scs obj3 = new Scs();
	obj3.name("Sunita");
	obj3.setage(45);
	obj3.setsal(300000);
	System.out.println("Department: D3 Name: " + obj3.name() + "Age: " + obj3.getage() + "sal: " + obj3.getsal());
 }
}

class D4 extends D3{
	public void FacD4(){
	Scs obj4 = new Scs();
	obj4.name("Dhruv");
	obj4.setage(36);
	obj4.setsal(400000);
	System.out.println("Department: D4 Name: " + obj4.name() + "Age: " + obj4.getage() + "sal: " + obj4.getsal());
 }
}

public class Admin{
 public static void main(String args[]){
	D4 obj = new D4();
	obj.FacD1();
	obj.FacD2();
	obj.FacD3();
	obj.FacD4();
 }
}