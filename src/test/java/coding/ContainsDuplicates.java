package coding;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicates {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,1};
        System.out.println(containsDuplicate(arr));
    }
    static boolean containsDuplicate(int[] arr){
        Set<Integer> set=new HashSet<>();
        for (int j : arr) {
            if (set.contains(j)) {
                return false;
            }
            set.add(j);
        }
        return true;
    }
}
