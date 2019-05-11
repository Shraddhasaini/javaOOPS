import java.io.File;
import java.io.IOException;
 
public class Assignment
{
   public static void main(String[] args)
   {
      File temp;
      try
      {
         temp = File.createTempFile("myTempFile", ".txt");
          
         boolean exists = temp.exists();
          
         System.out.println("Temp file exists : " + exists);
        if(temp.delete()) 
        { 
            System.out.println("File deleted successfully"); 
        } 
        else
        { 
            System.out.println("Failed to delete the file"); 
        } 
      } catch (IOException e)
      {
         e.printStackTrace();
      }
   }
}