import java.awt.*;
class awt_test extends Frame{
 awt_test(){
    Frame f= new Frame("Shraddha");  
    TextField t1,t2;  
    t1=new TextField("Welcome.");  
    t1.setBounds(50,100, 200,30);  
    t2=new TextField("AWT Frames");  
    t2.setBounds(50,150, 200,30);  
    f.add(t1); f.add(t2);  
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true); 
Button b = new Button("Click here");
b.setBounds(30,100,80,30);
b.setSize(400,400);
b.setLayout(null);
b.setVisible(true);
}
public static void main(String[] args){
awt_test a1= new awt_test();
}
} 