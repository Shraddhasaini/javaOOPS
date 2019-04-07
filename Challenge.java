package c284;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
/*
 * https://www.reddit.com/r/dailyprogrammer/comments/53ijnb/20160919_challenge_284_easy_wandering_fingers/
 */
public class Challenge {

	private static final String INPUT1 = "qwertyuytresdftyuioknn";
	private static final String INPUT2 = "gijakjthoijerjidsdfnokg";

	public static void main(String[] args) throws Exception {
		Collection<String> matches1 = findWords(INPUT1);
		Collection<String> matches2 = findWords(INPUT2);

		System.out.println("INPUT: " + INPUT1);
		System.out.println("MATCHES: " + matches1);
		System.out.println("INPUT: " + INPUT2);
		System.out.println("MATCHES: " + matches2);
	}

	private static Collection<String> findWords(final String input) throws Exception {
		Collection<String> res = new ArrayList<>();

		res = readSuppliedWords();

		// filter for potential matches (first and last letter matches)
		res = res.stream().filter(c -> c.length() >= 5)
				// check first char
				.filter(c -> c.startsWith(input.substring(0, 1)))
				// check last char
				.filter(c -> c.endsWith(input.substring(input.length() - 1, input.length())))
				// check if the char sequence matches to the input
				.filter(c -> charSequenceMatch(input, c))
				.collect(Collectors.toList());

		return res;
	}
	
	private static boolean charSequenceMatch(final String input, final String toMatch) {
		boolean res = true;
		int inputCursor = 0;
		final char[] toMatchChr = toMatch.toCharArray();
		for (int i = 0; i < toMatchChr.length; i++) {
			final int foundIdx = input.indexOf(toMatchChr[i], inputCursor);
			// when the current char cannot be found after the current cursor, end it
			if(foundIdx == -1 || foundIdx < inputCursor) {
				res = false;
				break;
			}
			inputCursor = foundIdx;
		}
		return res;
	}
	
	private static Collection<String> readSuppliedWords() throws FileNotFoundException {
		InputStream input = Challenge.class.getClassLoader().getResourceAsStream("c284/words.txt");
		List<String> res = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.toList());
		return res;
	}
}