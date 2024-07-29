package coding;

import java.util.Arrays;

public class RemoveDuplicatesSorted {
    public static void main(String[] args) {
        int[] nums={0,1,1,1,2,3,3};//[]
        //{0,1,1,1,2,3,3}
        // l=0,r=1, 0,1,1,1,2,3,3
        // l=1,r=2,
        // l=1,r=3,
        // l=1,r=4, 0,1,2,1,2,3,3
        // l=2,r=5, 0,1,2,3,2,3,3
        // l=3,r=6,
        //l=3, r=7
        removeDuplicates(nums);
    }
    public static void removeDuplicates(int[] nums) {
        int left=0;
        int right=1;
        while(left<nums.length && right<nums.length){
            if(nums[left]==nums[right]){
                right++;
            }else{
                nums[left+1]=nums[right];
                right++;
                left++;
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(left+1);

    }

}
