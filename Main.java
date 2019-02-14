class Cat
{ 
    public void cats() 
    { 
        System.out.println("kitten"); 
    } 
} 
  
class Lion extends Cat
{ 
    public void Lions() 
    { 
        System.out.println("Lion"); 
    } 
} 
public class Main
{ 
    public static void main(String[] args) 
    { 
        Lion g = new Lion(); 
        g.cats(); 
        g.Lions(); 
        g.cats(); 
    } 
} 