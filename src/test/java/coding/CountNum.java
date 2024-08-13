package coding;

import java.util.HashMap;
import java.util.Map;

public class CountNum {
    public static void main(String[] args) {
        String str = "9u8908u23445";

        getNumCount(str).entrySet()
                .forEach(k-> System.out.println(k.getKey()+"=="+k.getValue()));
    }

    static Map<Character, Integer> getNumCount(String str){
        Map<Character, Integer> map=new HashMap<>();
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            int count = 1;
            for(int j=i+1;j<arr.length;j++) {
                if (Character.isDigit(arr[i])) {
                    if(arr[i]==arr[j]){
                        count++;
                    }
                }
            }
            if(Character.isDigit(arr[i]))
                map.put(arr[i], map.getOrDefault(arr[i], count));
        }
        return map;
    }
}
