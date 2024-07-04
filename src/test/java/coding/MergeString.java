package coding;

import java.util.function.BiFunction;
import java.util.function.Function;

public class MergeString {
    public static void main(String[] args) {
        String word1 = "abc", word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2));
    }

    public static String mergeAlternately(String word1, String word2) {
        StringBuilder resultStr= new StringBuilder();
        BiFunction<String, String, String> newStr = (word_1, word_2)-> {
            String minLengthStr = "";
            if(word_1.length()>=word_2.length()) {
                minLengthStr = word_2;
            }
            else if(word_1.length()<word_2.length()){
                minLengthStr = word_1;
            }
            for (int i = 0; i < minLengthStr.length(); i++) {
                resultStr.append(word1.charAt(i)).append(word2.charAt(i));
            }
            return resultStr.toString();
        };
        if(word1.length()==word2.length()){
           return newStr.apply(word1, word2);
        }
        else if(word1.length()>word2.length()){
            return newStr.apply(word1, word2)+ word1.substring(word2.length());
        }
        else {
            return newStr.apply(word1, word2)+word2.substring(word1.length());
        }
    }
}
