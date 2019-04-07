import java.util.*;

class WanderingFingers {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> candidates = new ArrayList<>();
        while (in.hasNext()) {
            String word = in.nextLine();
            if (word.startsWith(args[0].substring(0, 1))
                && word.endsWith(args[0].substring(args[0].length() - 1, args[0].length()))
                && word.length() >= 5)
                candidates.add(word);
        }
        for (String word : candidates) {
            if (inside(word, args[0]))
                System.out.println(word);
        }
    }
    
    public static boolean inside(String word, String keyInput) {
        int j = 0;
        for (int i = 0; i < word.length(); i++)
            while (word.charAt(i) != keyInput.charAt(j)) {
                j++;
                if (j >= keyInput.length())
                    return false;
            }
        return true;
    }
}  