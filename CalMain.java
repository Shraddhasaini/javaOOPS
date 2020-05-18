class Add{
	public int c;
	public void sum(int a, int b){
	 c = a+b;
	System.out.println("sum of a and b is "+c);	



 }
}
class Mul extends Add{
	public int d;
	public void square(int x){
	d = x*x;
	System.out.println("square is "+d); 
 }
}
public class CalMain
{
	public static void main(String args[]){
	Mul obj = new Mul();
	obj.sum(10,20);
	obj.square(15);
}
}
