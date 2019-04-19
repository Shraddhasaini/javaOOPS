// Rename
import java.io.File; 
public class IO1 { 
    public static void main(String[] args) 
    { 
        File oldName = 
         new File("C:\Users\500062194\Desktop\javalab\renaming.txt"); 
        File newName =  
         new File("C:\Users\Siddharth\Desktop\javalab\renamed.txt"); 
        if (oldName.renameTo(newName))  
            System.out.println("Renamed successfully");         
        else 
            System.out.println("Error");         
    } 
} 