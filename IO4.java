import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class IO4
{
	public static void main(String[] args)
	{
		Scanner Sc=new Scanner(System.in);
		System.out.print("Enter the file name:");
		String sfilename=Sc.next();
		Scanner Sc1= null;
		FileInputStream fis=null;
		try
		{
		    FileInputStream FI=new FileInputStream(sfilename);
		    Sc1=new Scanner(FI);
		    while(Sc1.hasNext())
		    {
		    	String data=Sc1.nextLine();
		    	System.out.print("The file data is : " +data);
		    }
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}