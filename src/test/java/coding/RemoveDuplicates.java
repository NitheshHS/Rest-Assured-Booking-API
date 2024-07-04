package coding;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(arr);
    }

    public static void removeDuplicates(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]==arr[i+1]){
                arr[i]=-1;
            }
        }
        System.out.println(Arrays.toString(Arrays.stream(arr).filter(value -> value != -1).toArray()));
    }
}
