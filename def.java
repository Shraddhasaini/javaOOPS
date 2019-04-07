import javax.swing.JFrame;

class def
{
	JFrame f = new JFrame("Frame 1");
	def()
	{
		gui();
	}
	public void gui()
	{
		f.setSize(500,400);
		f.setVisible(true);
	}
	
	public static void main(String args[]){
	def obj = new def();
}
}