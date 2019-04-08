class reply{
public String Reply(String abc){
	String str001;
	switch(abc){
		case "hello": str001 = "Hi There";
				break;
		case "shraddha": str001=  "That's my name";
				break;
		case "university": str001 = "UPES";
				break;
		case "school": str001 = "IB school";
				break;
		case "thanks": str001= "Welcome";
				break;
		default: str001= "Sorry IDK";
			break;

}
return str001;

}
public static void main(String args[]){
		reply obj =new reply();
		obj.Reply("hello");
		System.out.println(str001);
}
}