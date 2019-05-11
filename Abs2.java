abstract class Abs{
abstract String pop();
}
class Abs2 extends Abs{
String pop(){
return "Hello";
}
public static void main(String args[]){
Abs2 obj = new Abs2();
String x = obj.pop();
System.out.println(x);
}
}
