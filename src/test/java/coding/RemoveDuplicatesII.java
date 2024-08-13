package coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatesII {
    public static void main(String[] args) {
        int arr[] = {0,0,1,1,1,1,2,3,3};
        System.out.println(removeDuplicates(arr));
        removeDuplicatesII(arr);
    }

    static void removeDuplicatesII(int[] arr){
        Map<Integer, Integer> map=new HashMap<>();
        int count=1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==arr[i+1]){
                count++;
            }
            if(count==2  && !map.containsKey(arr[i])){
                map.put(arr[i], map.getOrDefault(arr[i], count));
                count = 0;
            }
        }
        System.out.println(map);
    }

    static int removeDuplicates(int[] nums){
        int n = nums.length;
        if(n<=2){
            return n;
        }

        int j=2;
        for(int i=2;i<n;i++){
            if(nums[j]!=nums[j-2]){
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }
}
