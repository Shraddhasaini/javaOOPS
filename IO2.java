import java.io.*; 
public class IO2 
{ 
    public static void main(String[] args) 
    { 
        File file = new File("C:\\Users\\500062194\\Desktop\\javalab\\delete.txt"); 
          
        if(file.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
    } 
} 