class Exc0{
public static void main(String args[]){
try{
int d, a;
d=0;
a=18/0;
System.out.println("this method will not be printed");
}
catch (ArithmeticException e){
System.out.println("Division by zero");
}
}
}