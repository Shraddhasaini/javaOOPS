import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Prediction {

public static void main(String[] args) {
	ArrayList<String> inputs = new ArrayList<String>();
	Scanner wish = new Scanner(System.in);
	System.out.println("Enter the string:");
	inputs.add(wish.next());
	System.out.println(inputs);
	for (String input : inputs) {
		System.out.println(findWords(input));
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
}