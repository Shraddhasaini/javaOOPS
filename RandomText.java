import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import javafx.util.Pair;
import java.util.Scanner;

public class RandomText {

    final private Map<Pair<String,String>,Map<String,Integer>> data;

    public RandomText() {
        data = new HashMap<>();
    }

    public  void readFile(String fname) {
try{
            String prefix1 = "I";
            String prefix2 = "am";
	Scanner keyboard = new Scanner("StarTrek.txt");
	while (true) {
                Pair<String,String> pair = new Pair(prefix1, prefix2);
                if (!data.containsKey(pair)) {
                    data.put(pair, new HashMap<>());
               }
                Map<String,Integer> map = data.get(pair);

                String suffix = keyboard.next();
                map.put(suffix, map.containsKey(suffix) ? map.get(suffix) + 1 : 1);
              //  prefix1 = prefix2;
              //  prefix2 = suffix;
           //Pair<String,String> pair = new Pair(prefix1, prefix2);
          //  if (!data.containsKey(pair)) {
            //  data.put(pair, new HashMap<>());
        //   }
        //  Map<String,Integer> map = data.get(pair);
            map.put("", 1);
        //  keyboard.close();
}
} catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String generate() {
        return generate(0);
    }

    public String generate(int limit) {
        Random random = new Random();
        String res = "";
        String prefix1 = "";
        String prefix2 = "";
        int words = 0;
        while (true) {
            Pair<String,String> pair = new Pair(prefix1, prefix2);
            String suffix = "";
            if (data.containsKey(pair)) {
                Map<String,Integer> map = data.get(pair);
                int n = 0;
                for (int w : map.values()) {
                    n += w;
                }
                int i = random.nextInt(n);
                for (Entry<String,Integer> entry : map.entrySet()) {
                    i -= entry.getValue();
                    if (i < 0) {
                        suffix = entry.getKey();
                        break;
                    }
                }
            }
            if (suffix.equals("")) {
                break;
            }
            res += res.equals("") ? suffix : " " + suffix;
            words++;
            if (limit > 0 && words == limit) {
                break;
            }
            prefix1 = prefix2;
            prefix2 = suffix;
        }
        return res;
    }

    public static void main(String[] args) {
        RandomText randomText = new RandomText();
        randomText.readFile("StarTrek.txt");
        System.out.println(randomText.generate());
    }

}
