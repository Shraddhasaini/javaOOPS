class Parent{
 public void method1(int a,int b){
System.out.println("Ans:"+(a+b));
}
public void method2(){
System.out.println("Parent");
}
}
class Child extends Parent{
public void method1(char a,char b){
System.out.println("Ans: "+(a+b));
}
public void method2(){
System.out.println("CHild");
}
}
class Main02
{
public static void main(String args[]){
Parent obj1 = new Parent();
obj1.method1(1,2);
obj1.method1('b','a');
obj1.method2();
Child obj2 = new Child();
obj2.method2();
}

}