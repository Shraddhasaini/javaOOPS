class Thread1{
	public void funThread(){
	for(i=0;i<=10;i++){
	System.out.println("no.:" +i);
 }
	sleep(1000);
}
}
class MainThread{
public static void main(String args[]){
	Thread1 obj = new Thread1();
	obj.funThread();
}
}