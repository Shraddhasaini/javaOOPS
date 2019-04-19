import java.io.*; 
public class IO3 
{ 
    public static void main(String[] args) 
    { 
        File file = new File("C:\\Users\\500062194\\Desktop\\javalab\\permissions.txt"); 
        boolean exists = file.exists(); 
        if(exists == true) 
        { 
            System.out.println("Executable: " + file.canExecute()); 
            System.out.println("Readable: " + file.canRead()); 
            System.out.println("Writable: "+ file.canWrite()); 
        } 
        else
        { 
            System.out.println("File not found."); 
        } 
    } 
} 