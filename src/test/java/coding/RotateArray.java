package coding;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
       int[] nums = {1,2,3,4,5,6,7};//[7,2,3,4,5,6,1]->[7,6,3,4,5,2,1]->[7,6,5,4,3,2,1]

        //[1,2,3,4,5,6,7]
        // 7,1,2,3,4,5,6
        //6,7,1,2,3,4,5
        //5,6,7,1,2,3,4
        //Output: [5,6,7,1,2,3,4]
        //[7,1,2,3,4,5,6]
        //7,6,5,4,3,2,1
        //5,6,7,1,2,3,4
        int k=3;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, 2);
        reverse(nums, k, nums.length-1);
    }

    static void reverse(int[] arr, int p1, int p2){
        while(p1<p2){
            int temp=arr[p1];
            arr[p1]=arr[p2];
            arr[p2]=temp;
            p1++;
            p2--;
        }
    }
}
