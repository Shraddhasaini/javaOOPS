class Pilot{
	public String Direction;
	public int Speed;
	public String gun;
	public String missiles;
	public String sonar;
	public String radar;
 public void Fly(){
	Direction = "UP";
	Speed = 150;
	System.out.println("Dierection: " +Direction +" Speed: " +Speed);
	
 }
}

class CoPilot extends Pilot{
	public void Fight(){
	gun = "gun two";
	missiles = "Not invoked";
	sonar = "Not invoked";
	radar = "Not invoked";
	System.out.println("gun: " +gun +" missiles: " +missiles +" sonar: " +sonar +" radar: " +radar);
 }
}
public class MIG{
 public static void main(String args[]){
	CoPilot obj = new CoPilot();
	obj.Fly();
	obj.Fight();
}
}