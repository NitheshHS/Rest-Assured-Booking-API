package coding;

import java.util.Arrays;

public class MergeArray {
    public static void main(String[] args) {
        int[] nums1={1, 2, 3, 0, 0, 0};//[1,2,2,3,5,6]
        int[] nums2={2,5,6};//1,2,2,0,0,0 3,5,6
        // 123000
        //356
        System.out.println(Arrays.toString(merge(nums1, 3, nums2, 3)));
    }
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=0;
        int p2=0;
        while(p1<m && p2<n){
            if(nums1[p1]<=nums2[p2]){
                p1++;
            }else if(nums1[p1]>nums2[p2]){
                int temp=nums1[p1];
                nums1[p1]=nums2[p2];
                nums2[p2] = temp;
                p1++;
            }
        }
        while(p1<m+n){
            nums1[p1]=nums2[p2];
            p1++;
            p2++;
        }
        return nums1;
    }
}
