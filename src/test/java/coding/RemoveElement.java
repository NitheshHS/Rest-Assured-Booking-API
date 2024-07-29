package coding;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int[] arr={3,2,3,2,3};//[2,3,3,2,3]->[2,2,3,3,3,3]
        System.out.println(removeElement(arr, 3));
    }
    static int removeElement(int[] arr, int val){
       int p=0;
       for(int i=0;i<arr.length;i++){
           if(arr[i]!=val){
               arr[p]=arr[i];
               p++;
           }
       }
        return p;
    }
}
