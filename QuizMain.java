import java.util.Scanner;
class Ques{
	public void ques(){
	System.out.println("What is the captial of HARYANA? 1.Rohtak 2.Jind 3.Chandigarh 4.Gurugram");
 }
}
class Ans extends Ques{
	public String answ(){
	Scanner sc = new Scanner(System.in);
	int opt = sc.nextInt();
	String answer;
	switch(opt){
	case 1:
	answer= "Incorrect";
	break;
	case 2:
	answer= "Incorrect";
	break;
	case 3:
	answer= "Correct";
	break;
	case 4:
	answer= "Incorrect";
	break;
	default:
	answer = "Incorrect";
	break;
}
	return answer;
}
}
public class QuizMain
{
	public static void main(String args[]){
	Ans obj = new Ans();
int n=3;	
while(n!=0)
	{
		obj.ques();
	String answer=obj.answ();
	if (answer=="Incorrect"){
	System.out.println("Please retry again");
	
	} 
	else
	System.out.println("correct ans");
n--;	
}
}

}