package coding;

import io.cucumber.java.sl.In;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Anagram {
    public static void main(String[] args) {
        String str1 = "nitheeshm";
        String str2 = "eshnithen";
        System.out.println(getCharCounter(str1));
        System.out.println(getCharCounter(str2));
        System.out.println(isAnagram(str1, str2));
    }

    static boolean isAnagram(String str1, String str2) {
        boolean flag = false;
        if(str1.length()!=str2.length()){
           return false;
       }else{
           Map<Character, Integer> map = getCharCounter(str1), map2=getCharCounter(str2);
           for(int i=0;i<str1.length();i++){
                if(map.get(str1.charAt(i))!=map2.get(str1.charAt(i))){
                    return false;
                }else{
                    flag = true;
                }
           }
       }
        return flag;
    }

    static Map<Character, Integer> getCharCounter(String str){
        Map<Character, Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i))){
               map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0));
            }else{
                int val = map.get(str.charAt(i))+1;
                map.put(str.charAt(i), val);
            }
        }
        return map;
    }

}
