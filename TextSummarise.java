import java.util.*;
    import java.io.*;
    import java.text.*;
    public class TextSummarise {
    static List<String> lines = new ArrayList<String>();
    static String[] arr;
    static ArrayList<String> text = new ArrayList<>();
    static HashMap hash = new HashMap();
    static Map map;
    static HashMap hashSentence = new HashMap();
    static Map mapSentence;
    static String[] bestScore = new String[4];
    static ArrayList<String> sentence = new ArrayList<>();

    static String[] summarise = new String[4];


    public static void toArray(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        for (String s: lines){
            s=s.replaceAll("\\s+","");
        }
         arr = lines.toArray(new String[0]);

    }
    public static String toString(String file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void countOccurrences(ArrayList<String> asList){
        //List asList = Arrays.asList(text);
        Set<String> mySet = new HashSet<String>(asList);
        for(String s: mySet){

            //System.out.println(s + " " +Collections.frequency(asList,s));
            hash.put(s,Collections.frequency(asList,s));

        }
    }

    public static void printMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println(entry.getKey() + ": "+ entry.getValue());
        }
    }

    public static <K, V extends Comparable<? super V>> Map<K, V>
    sortByValue( Map<K, V> map )
    {
        List<Map.Entry<K, V>> list =
                new LinkedList<Map.Entry<K, V>>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<K, V>>()
        {
            public int compare( Map.Entry<K, V> o1, Map.Entry<K, V> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );

        Map<K, V> result = new LinkedHashMap<K, V>();
        for (Map.Entry<K, V> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }

        return result;
    }




    public static void main(String arg[]) throws IOException {
        String txt = toString("out/production/DailyProgrammer/text.txt");
        String[] temp = txt.split("\\s+");
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.ENGLISH);
        iterator.setText(txt);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            sentence.add(txt.substring(start, end));
        }
         int[] bestSentence = new int[sentence.size()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = temp[i].replaceAll(",$", "");
            temp[i] = temp[i].replaceAll("\\.", "");
            text.add(temp[i]);
        }

        //System.out.print(Arrays.toString(temp));
        String str = toString("out/production/DailyProgrammer/stopword.txt");
        String[] stopword = str.split("\\s+");
        for (int i = 0; i < text.size(); i++) {
            for (int j = 0; j < stopword.length; j++) {
                if (text.get(i).equalsIgnoreCase(stopword[j])) {
                    text.remove(text.get(i));
                }
            }

            //System.out.println(text.get(i));
        }
        int count = 0;


        countOccurrences(text);
        map = sortByValue(hash);

        bestScore[0]= (String) map.keySet().toArray()[map.size()-1];
        bestScore[1]=   (String) map.keySet().toArray()[map.size()-2];
        bestScore[2]=   (String) map.keySet().toArray()[map.size()-3];
        bestScore[3]=   (String) map.keySet().toArray()[map.size()-4];
        for (String s : sentence) {
            for (String t : bestScore) {
                if (s.contains(t)) {
                    bestSentence[count]++;
                }
            }
            count++;
        }
        System.out.println(Arrays.toString(bestSentence));
        for (int j=0;j<sentence.size();j++) {

                hashSentence.put(sentence.get(j), bestSentence[j]);

        }
        mapSentence=sortByValue(hashSentence);
        summarise[0]=(String) mapSentence.keySet().toArray()[mapSentence.size()-1];
        summarise[1]=(String) mapSentence.keySet().toArray()[mapSentence.size()-2];
        summarise[2]=(String) mapSentence.keySet().toArray()[mapSentence.size()-3];
        summarise[3]=(String) mapSentence.keySet().toArray()[mapSentence.size()-4];
        //System.out.print(Arrays.toString(bestSentence));
       // bestScore[0]=map.values().toArray([map.size()-1]);
        //System.out.println(bestScore[0]+"\n"+bestScore[1]+"\n"+bestScore[2]+"\n"+bestScore[3]);
        //printMap(mapSentence);
        for (int i=0;i<summarise.length;i++){
            System.out.println(summarise[i]);
        }
    }
    }
