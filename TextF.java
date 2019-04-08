import java.awt.Frame;
import java.awt.TextField;
import java.awt.Button;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TextF extends Frame implements ActionListener{
	Frame f= new Frame("Word Prediction");
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18,tf19,tf20,tf21;
	Button b,bh,bc,br1,br2,br3,br4;
	TextF(){
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
	tf7=new TextField();  
        tf7.setBounds(50,350,100,20); 
	tf7.setEditable(false);
	tf8=new TextField();  
        tf8.setBounds(200,350,100,20); 
	tf8.setEditable(false);
	tf9=new TextField();  
        tf9.setBounds(50,400,100,20); 
	tf9.setEditable(false);
	tf10=new TextField();  
        tf10.setBounds(200,400,100,20); 
	tf10.setEditable(false);
	tf11=new TextField();  
        tf11.setBounds(50,500,100,20); 
	tf11.setEditable(false);
	tf12=new TextField();  
        tf12.setBounds(200,500,100,20); 
	tf12.setEditable(false);
	tf13=new TextField();  
        tf13.setBounds(50,550,100,20); 
	tf13.setEditable(false);
	tf14=new TextField();  
        tf14.setBounds(200,550,100,20); 
	tf14.setEditable(false);
	tf15=new TextField("The length of String you entered is: ");  
        tf15.setBounds(50,600,200,20); 
	tf15.setEditable(false);
	tf16=new TextField();  
        tf16.setBounds(300,600,50,20); 
	tf16.setEditable(false);
	tf17=new TextField("Common replies:");  
        tf17.setBounds(800,50,300,20); 
	tf17.setEditable(false);
	tf18=new TextField();  
        tf18.setBounds(800,100,300,20); 
	tf18.setEditable(false);
	tf19=new TextField();  
        tf19.setBounds(800,150,300,20); 
	tf19.setEditable(false);
	tf20=new TextField();  
        tf20.setBounds(800,200,300,20); 
	tf20.setEditable(false);
	tf21=new TextField();  
        tf21.setBounds(800,250,300,20); 
	tf21.setEditable(false);
	b = new Button("Predict");
	b.setBounds(50,150,300,20);
	b.addActionListener(this);
	bh = new Button("Hyphenate");
	bh.setBounds(50,300,300,20);
	bh.addActionListener(this);
	bc = new Button("Count alphabets");
	bc.setBounds(50,450,300,20);
	bc.addActionListener(this);
	br1 = new Button("1. Reply");
	br1.setBounds(700,100,50,20);
	br1.addActionListener(this);
	br2 = new Button("2. Reply");
	br2.setBounds(700,150,50,20);
	br2.addActionListener(this);
	br3 = new Button("3. Reply");
	br3.setBounds(700,200,50,20);
	br3.addActionListener(this);
	br4 = new Button("4. Reply");
	br4.setBounds(700,250,50,20);
	br4.addActionListener(this);
	f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);f.add(tf7);f.add(tf8);f.add(tf9);f.add(tf10);f.add(b);f.add(bh);
	f.add(tf11);f.add(tf12);f.add(tf13);f.add(tf14);f.add(tf15);f.add(tf16);f.add(tf17);f.add(tf18);f.add(tf19);f.add(tf20);f.add(tf21);
	f.add(bc);f.add(br1);f.add(br2);f.add(br3);f.add(br4);
	f.setSize(300,300);
	f.setLayout(null);
	f.setVisible(true);
 }

public void actionPerformed(ActionEvent e){
	ArrayList<String> inputs = new ArrayList<String>();
	String s1 = tf2.getText();
	String s2 = tf3.getText();
	String s3 = tf4.getText();
	String s4 = tf5.getText();
	String s5 = tf6.getText();
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
		String[] words = {s2,s3,s4,s5};
		if(e.getSource()==bh){
			 for (String s : words){
			String word01 = hyphenateWord(s2);
			tf7.setText(word01);
			String word02 = hyphenateWord(s3);
			tf8.setText(word02);
			String word03 = hyphenateWord(s4);
			tf9.setText(word03);
			String word04 = hyphenateWord(s5);
			tf10.setText(word04);
		}
		}
			int len1 = s2.length();
			String len01 = String.valueOf(len1);
			int len2 = s3.length();
			String len02 = String.valueOf(len2);
			int len3 = s4.length();
			String len03 = String.valueOf(len3);
			int len4 = s5.length();
			String len04 = String.valueOf(len4);
			int len5 = s1.length();
			String len05 = String.valueOf(len5);
		if(e.getSource()==bc){
			tf11.setText(len01);
			tf12.setText(len02);
			tf13.setText(len03);
			tf14.setText(len04);
			tf16.setText(len05);
		}
			if(e.getSource()==br1){
				for (String str :words){
				String str002 = Reply(s2);
				tf18.setText(str002);
				}}
			if(e.getSource()==br2){
				for (String stri :words){
				String str003 = Reply(s3);
				tf19.setText(str003);
				}}
			if(e.getSource()==br3){
				for (String st :words){
				String str004 = Reply(s4);
				tf20.setText(str004);
				}}
			if(e.getSource()==br4){
				for (String strin :words){
				String str005 = Reply(s5);
				tf21.setText(str005);
				}}

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

    private static List<String> patterns = load("tex-hyphenation-patterns.txt");
	public static List<String> load(String filename) {
        try {
            patterns = Files.readAllLines(Paths.get(filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return patterns;
    }

    public static String hyphenateWord(String word) {
        ArrayList<HashMap<Integer, Integer>> matches = getMatches(word);
        int[] final_vals = new int[word.length()];

        for (Iterator<HashMap<Integer, Integer>> i = matches.iterator(); i.hasNext();) {
            HashMap<Integer, Integer> item = i.next();
            for (Iterator k = item.entrySet().iterator(); k.hasNext();) {
                Map.Entry pair = (Map.Entry) k.next();
                int idx_in_word = (int) pair.getKey();
                int value = (int) pair.getValue();

                if (value > final_vals[idx_in_word])
                    final_vals[idx_in_word] = value;
            }

        }

        int hypen_off = 0;
        for (int i = 0; i < final_vals.length; i ++) {
            if (final_vals[i] % 2 == 1) {
                word = word.substring(0, i + hypen_off) + '-' + word.substring(i + hypen_off);
                hypen_off ++;
            }
        }

        return word;
    }

    public static ArrayList<HashMap<Integer, Integer>> getMatches(String word) {
        ArrayList<HashMap<Integer, Integer>> all_matched_vals = new ArrayList<>();

        for (String p : patterns) {
            HashMap<Integer, Integer> matchVals = getMatchValuesOf(p, word);

            if (matchVals != null)
                all_matched_vals.add(matchVals);
        }

        return all_matched_vals;
    }

    public static HashMap<Integer, Integer> getMatchValuesOf(String pattern, String word) {
        int matchLoc = getMatchLoc(word, pattern);

        if (matchLoc == -1)
            return null;

        HashMap<Integer, Integer> matched_vals = new HashMap<>();
        int pattern_idx = 0;
        for (int i = matchLoc; pattern_idx < Math.min(pattern.length(), word.length() - matchLoc); i ++) {
            char current = pattern.charAt(pattern_idx);

            while ((Character.isDigit(current) || current == '.')) {
                if (Character.isDigit(current))
                    matched_vals.put(i, Integer.parseInt(Character.toString(current)));

                if (pattern_idx + 1 < pattern.length() - 1) {
                    pattern_idx ++;
                    current = pattern.charAt(pattern_idx);
                }
                else break;
            }
            pattern_idx ++;
        }

        return matched_vals;
    }

    public static int getMatchLoc(String word, String pattern) {
        String no_num_pattern = pattern.replaceAll("\\d|\\.","");

        int match_loc;

        if (pattern.charAt(0) == '.') {
            match_loc = (word.startsWith(no_num_pattern)) ? 0 : -1;
        }
        else if (pattern.charAt(pattern.length() - 1) == '.') {
            match_loc = (word.endsWith(no_num_pattern)) ? word.length() - 1 : -1;
        } else {
            match_loc = word.indexOf(no_num_pattern);
        }
        return match_loc;
    }

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
		case "saksham": str001= "I LOVE YOU";
				break;
		case "ankit": str001= "Bhnji";
				break;
		case "dhruv": str001= "dhruv pagal h";
				break;
		default: str001= "Sorry IDK";
			break;

}
return str001;
}

public static void main(String[] args){
	new TextF();
}
}