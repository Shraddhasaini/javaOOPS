import java.io.*;
abstract class Shape {
	abstract void draw();
}
abstract class Rectangle extends Shape {
}
abstract class Circle extends Rectangle {
}
public class Triangle extends Circle {
void draw(){
System.out.println("this is abstraction function");
}
public static void main(String args[])throws IOException
{
Triangle T= new Triangle();
T.draw();
}
}