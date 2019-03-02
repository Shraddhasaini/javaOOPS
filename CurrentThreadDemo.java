class Myclass extends Thread{
	public void run(){
for(int i=0; i<10;i++){
System.out.println(Thread.currentThread().getId()+" value "+i);
try{
Thread.sleep(2000);
}
catch (InterruptedException e){
e.printStackTrace();
   }
  }
 }
}
public class CurrentThreadDemo{
public static void main(String args[]){
Myclass myClass1=new Myclass();
myClass1.start();
Myclass myClass2=new Myclass();
myClass2.start();
 }
}