class Tea{
   public Tea()
   {
	System.out.println("Class Tea");
   }
   public void DrinkType()
   {
	System.out.println("Drink Type: Tea");
   }
}
class Green extends Tea{
   public Green()
   {
	System.out.println("Class Green");
   }
   public void type()
   {
	System.out.println("type: Green");
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
	 obj.DrinkType();
	 obj.type();
	 obj.taste();
   }
}