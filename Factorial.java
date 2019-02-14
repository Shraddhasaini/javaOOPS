public class Factorial
{
void Facto()
{
int i, fact = 1;
int num = 5;
for(i=1;i<=num;i++)
{
		fact=fact*i;
}
	System.out.println("The factorial of " +num  +" is " +fact);
}

public static void main(String args[]){
	Factorial f = new Factorial();
	f.Facto();
}
}