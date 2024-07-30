package coding;

public class RemoveDuplicateI {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
    //[0,0,1,1,1,2,2,3,3,4]
    //   | |
    //[0,1,1,1,1,2,2,3,3,4]
    //     |     |
    //[0,1,2,1,1,2,2,3,3,4]
    //       |     |
    //[0,1,2,3,1,2,2,3,3,4]
    //         |       |
    public static int removeDuplicates(int[] nums) {
       if(nums.length<=0){
           return 0;
       }
        int i=1;
       for(int j=1;j<nums.length;j++){
           if(nums[j]!=nums[j-1]){
               nums[i]=nums[j];
               i++;
           }
       }
       return i;
    }

}
