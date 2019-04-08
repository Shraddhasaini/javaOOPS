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
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
	Button b,bh;
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
	b = new Button("Predict");
	b.setBounds(50,150,300,20);
	b.addActionListener(this);
	bh = new Button("Hyphenate");
	bh.setBounds(50,300,300,20);
	bh.addActionListener(this);
	f.add(tf1);f.add(tf2);f.add(tf3);f.add(tf4);f.add(tf5);f.add(tf6);f.add(tf7);f.add(tf8);f.add(tf9);f.add(tf10);f.add(b);f.add(bh);
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



public static void main(String[] args){
	new TextF();
}
}