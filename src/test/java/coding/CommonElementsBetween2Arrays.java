package coding;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CommonElementsBetween2Arrays {
    public static void main(String[] args) {
        String[] arr1
                = { "Article", "in", "Geeks", "for", "Geeks" };
        String[] arr2 = { "Geeks", "for", "Geeks" };
        findCommonElements(arr1, arr2);
    }

    public static void findCommonElements(String[] arr1, String[] arr2){
        Set<String> duplicates = new HashSet<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if(Objects.equals(arr1[i], arr2[j])){
                    duplicates.add(arr1[i]);
                }
            }
        }
        duplicates.forEach(System.out::println);
    }
}
