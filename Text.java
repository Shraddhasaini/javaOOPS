import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Text extends Frame implements ActionListener{
	Frame f= new Frame("Word Prediction");
	TextField tf1,tf2,tf3,tf4,tf5,tf6;
	Button b;
	Text(){
	tf1 = new TextField("Enter the word by gliding your fingers");
	 tf1.setBounds(50,50,300,20);
	tf1.setEditable(false);
	 tf2=new TextField();  
        tf2.setBounds(50,100,300,20);  
        tf3=new TextField();  
        tf3.setBounds(50,200,100,20); 
	tf3.setEditable(false);
	tf4=new TextField();  
        tf4.setBounds(200,200,100,20); 
	tf4.setEditable(false); 
	tf5=new TextField();  
        tf5.setBounds(50,250,100,20); 
	tf5.setEditable(false); 
	tf6=new TextField();  
        tf6.setBounds(200,250,100,20); 
	tf6.setEditable(false);  
	b = new Button("Predict");
	b.setBounds(50,150,300,20);
	b.addActionListener(this);
	f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);f.add(b);
	f.setSize(300,300);
	f.setLayout(null);
	f.setVisible(true);
 }

public void actionPerformed(ActionEvent e){
	ArrayList<String> inputs = new ArrayList<String>();
	String s1 = tf2.getText();
	inputs.add(s1);
	if(e.getSource()==b){
		for (String input : inputs) {
		ArrayList<String> WordsList = findWords(input);
		int size = WordsList.size();
		switch (size){
		case 0:
		tf3.setText("WORD");
		tf4.setText("DOES");
		tf5.setText("NOT");
		tf6.setText("EXIST");
		break;
		case 1:
		String res01 = WordsList.get(0);
		tf3.setText(res01);
		tf4.setText("----");
		tf5.setText("----");
		tf6.setText("----");
		break;
		case 2:
		String res11 = WordsList.get(0);
		String res12 = WordsList.get(1);
		tf3.setText(res11);
		tf4.setText(res12);
		tf5.setText("----");
		tf6.setText("----");
		break;
		case 3:
		String res21 = WordsList.get(0);
		String res22 = WordsList.get(1);
		String res23 = WordsList.get(2);
		tf3.setText(res21);
		tf4.setText(res22);
		tf5.setText(res23);
		tf6.setText("----");
		break;
		case 4:
		String res31 = WordsList.get(0);
		String res32 = WordsList.get(1);
		String res33 = WordsList.get(2);
		String res34 = WordsList.get(3);
		tf3.setText(res31);
		tf4.setText(res32);
		tf5.setText(res33);
		tf6.setText(res34);
		break;
	}
	}
	}
	}

public static ArrayList<String> findWords(String input) {
	String firstLetter = input.substring(0, 1);
	String lastLetter = input.substring(input.length() - 1);
	ArrayList<String> choices = getChoices(firstLetter, lastLetter);
	ArrayList<String> matches = new ArrayList<String>();

	for (String choice : choices) {
		String inputCopy = input;
		String choiceCopy = choice;

		while (inputCopy.length() > 0 && choiceCopy.length() > 0) {
			if (inputCopy.charAt(0) == choiceCopy.charAt(0)) {
				if (choiceCopy.length() >= 2 && choiceCopy.charAt(0) == choiceCopy.charAt(1)) {
					choiceCopy = choiceCopy.substring(2);
				} else {
					choiceCopy = choiceCopy.substring(1);
				}
			}
			inputCopy = inputCopy.substring(1);
		}
		if (choiceCopy.isEmpty()) {
			matches.add(choice);
		}
	}
	return matches;
}

public static ArrayList<String> getChoices(String firstLetter, String lastLetter) {
	ArrayList<String> strings = new ArrayList<String>();
	Scanner scanner = null;
	try {
		scanner = new Scanner(new File("enable1.txt"));
		while (scanner.hasNextLine()) {
			String word = scanner.nextLine();
			if (word.length() >= 5 && word.substring(0, 1).equals(firstLetter)
					&& word.substring(word.length() - 1).equals(lastLetter)) {
				strings.add(word);
			}
		}
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} finally {
		if (scanner != null) {
			scanner.close();
		}
	}
	return strings;
}

public static void main(String[] args){
	new Text();
	
}

}