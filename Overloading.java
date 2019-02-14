class Overloading
{
    public void wish(char c)
    {
         System.out.println(c);
    }
    public void wish(char c,int x)  
    {
         System.out.println(c + " " +x);
    }
}
class Shraddha
{
   public static void main(String args[])
   {
       Overloading obj = new Overloading();
       obj.wish('s');
       obj.wish('s',18);
   }
}
