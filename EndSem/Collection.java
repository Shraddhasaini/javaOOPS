import java.util.*;
class Collection{
public static void main(String args[]){
//list
List<String> students = new ArrayList<String>();
students.add("Shraddha");
students.add("Saksham");
students.add("prakhar");
students.add("sajal");
students.add("ankit");
for(String a:students){
System.out.println(a);
}
//Vectors
Vector<String> places = new Vector<String>();
places.add("rohtak");
places.add("rurkee");
places.add("Palampur");
Iterator<String> itrv = places.iterator();
while(itrv.hasNext()){ System.out.println(itrv.next());}
//Stack
Stack<String> food = new Stack<String>();  
food.push("pizza");  
food.push("pasta");  
food.push("lasagna");  
food.pop();  
Iterator<String> itrs=food.iterator();  
while(itrs.hasNext()){  
System.out.println(itrs.next());  
}
//Hashtables
Hashtable<String,String> x = new Hashtable<String,String>();
x.put("Shraddha","Saini");
x.put("Saksham","Hooda");
x.put("prakhar","Aggarwal");
x.put("sajal","Sood");
x.put("ankit","Kundu");
for(Map.Entry b:x.entrySet()){
System.out.println(b.getKey()+" "+b.getValue());}
}
}