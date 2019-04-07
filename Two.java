class One{
	private int age;
	get age(){
	return age;
}
	set newage(int age){
	age= newage;
}
}
class Two extends One {
	public static void main(String args[]){
	One obj = new One();
	obj.newage(2);
}
}