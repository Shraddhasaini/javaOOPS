package pkg284easy;
import java.util.*;
import java.io.*;

public class Saksham {
    public static void main(String[] args) throws FileNotFoundException {
        File infile = new File("enable1.txt");
        Scanner dict = new Scanner(infile);
        Scanner input = new Scanner(System.in);

      
        String inputword = input.nextLine();

        String output = "-----Output-----\n";

        while(dict.hasNextLine()){
            String dictword = dict.nextLine();
            
            if(dictword.charAt(0) != inputword.charAt(0) || dictword.charAt(dictword.length()-1) != inputword.charAt(inputword.length()-1)){
                //System.out.println("Caught One!");
            }
            else{
                int c = 0;
                for(int i = 0; ((i < (inputword.length())) && (c < dictword.length())) ; i++){
                    if(inputword.charAt(i) == dictword.charAt(c)){
                        c++;

                    }
                }
                if(c == dictword.length()){
                    output += dictword + "\n";
                    //System.out.println(dictword);
                }
                else{
                    //System.out.println("HAHAHA!!! :: " + dictword + " :: " + inputword);
                }
            }
        }
        System.out.println(output);
    }
}