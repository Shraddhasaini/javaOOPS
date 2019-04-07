import java.awt.*;
class awt_test extends Frame{
 awt_test(){
Button b = new Button("Click here");
b.setBounds(30,100,80,30);
setSize(400,400);
setLayout(null);
setVisible(true);
}
public static void main(String[] args){
awt_test a1= new awt_test();
}
}
