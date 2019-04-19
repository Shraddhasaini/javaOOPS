class Tea{
   public Tea()
   {
	System.out.println("Class Tea");
   }
   public void type(int a)
   {
	System.out.println("the type of drink rates:" +a);
   }
}
class Green extends Tea{
   public Green()
   {
	System.out.println("Class Green");
   }
   public void type(String s)
   {
	System.out.println("type: " +s);
   }
   public void taste()
   {
	System.out.println("bitter");
   }
}
public class Lemon extends Green{

   public Lemon()
   {
	System.out.println("Lemon");
   }
   public void taste()
   {
	System.out.println("citrus");
   }
   public static void main(String args[])
   {	
	 Lemon obj=new Lemon();
	 obj.type(10);
	 obj.type("Green");
	 obj.taste();
	Green obj2=new Green();
	obj2.taste();
   }
}