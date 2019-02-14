class one 
{ 
    public void wish() 
    { 
        System.out.println("wish"); 
    } 
} 
  
class two extends one 
{ 
    public void wishi() 
    { 
        System.out.println("x"); 
    } 
} 
public class Main
{ 
    public static void main(String[] args) 
    { 
        two g = new two(); 
        g.wish(); 
        g.wishi(); 
        g.wish(); 
    } 
} 