class TasteException extends Exception
{
	public TasteException(String msg)
	{
	super(msg);
	}
}
public class Exc2{
public static void main(String arg[]){
new TasteException("The Food taste bad");
try{
throw new TasteException("taste of food");
}
catch (TasteException e){
System.out.println("Complaint of unusual taste");
String s = e.getMessage();
if (s != null)
System.out.println(s);
}
}
}