import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordHyp {
    private static List<String> patterns = load("tex-hyphenation-patterns.txt");

    public static List<String> load(String filename) {
        // loads all of the lines of a file into a list
        try {
            patterns = Files.readAllLines(Paths.get(filename));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return patterns;
    }

    public static String hyphenateWord(String word) {
        // Returns a the hyphenated word
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
        // Returns each digit location and their corresponding value in a Hashmap.
        // Each Hashmap represents a different pattern that matched the word
        //
        // each matched_position hashmap is a hashmap containing all of the
        // matched positions in the word and their corresponding digit value
        //
        // ex. {idx_in_word=value, idx_in_word=value], ...}
        // ex. {0=5, 1=2, ...}
        ArrayList<HashMap<Integer, Integer>> all_matched_vals = new ArrayList<>();

        for (String p : patterns) {
            HashMap<Integer, Integer> matchVals = getMatchValuesOf(p, word);

            if (matchVals != null)
                all_matched_vals.add(matchVals);
        }

        return all_matched_vals;
    }

    public static HashMap<Integer, Integer> getMatchValuesOf(String pattern, String word) {
        // Gets the matched values of a single word
        // see getMatches(...) for more info
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

    public static void main(String[] args) {
        //System.out.println(hyphenateWord("recursion "));
        String[] words = {
                "mistranslate", "alphabetical", "bewildering", "buttons",
                "ceremony", "hovercraft", "lexicographically", "programmer", "recursion"
        };
        for (String s : words)
            System.out.println(hyphenateWord(s));
    }
}
