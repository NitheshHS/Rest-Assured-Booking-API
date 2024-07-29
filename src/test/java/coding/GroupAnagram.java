package coding;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        List<String> list = List.of("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagrams(list));
    }
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> map=new HashMap<>();
        for(String word:words){
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedStr=new String(charArr);
            if(!map.containsKey(sortedStr)){
                map.put(sortedStr,new ArrayList<>());
            }
            map.get(sortedStr).add(word);
        }
        return map.values().stream().toList();
    }
}
