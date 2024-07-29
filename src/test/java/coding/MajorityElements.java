package coding;

public class MajorityElements {
    //[2,2,1,1,1,2,2]//[323]-3] n * (n-1) =
    // |           |
    public static void main(String[] args) {
        int[] nums={6,5,6,5,6};
        System.out.println(bouerMoreVoting(nums));
    }
    public static int majorityElement(int[] nums) {
        int max=0;
        int p1=0;
        int p2=1;
        int count=0;
        int intialCount = 0;
        while(p1<nums.length){
            if(nums[p1]==nums[p2]){
                count++;
            }
            p2++;
            if(p2>=nums.length){
                if(count>intialCount){
                    max = nums[p1];
                    intialCount = count;
                }
                count =0;
                p1++;
                p2=p1;

            }
        }
        return max;
    }

    public static int bouerMoreVoting(int[] nums){
        int candidate = nums[0];
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }
}
