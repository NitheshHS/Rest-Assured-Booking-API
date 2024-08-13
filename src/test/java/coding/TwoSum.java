package coding;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,11,12};//15
        System.out.println(Arrays.toString(twoSum(arr, 15)));
    }

    public static int[] twoSum(int[] arr, int sum){
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            int diff = Math.subtractExact(sum, arr[i]);//7-9=2
            if(map.containsKey(diff)){
               return new int[]{i,map.get(diff)};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }

    /*
        [2,7,11,15]
        //1: 9-2=7 false, {2:0}
        //2; 9-7=2 true,  {0,1}
     */
    public int[] twoSumII(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int diff=target - nums[i];
            if(map.containsKey(diff)){
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
}
