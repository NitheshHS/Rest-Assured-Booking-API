package coding;

import java.util.Arrays;

public class FindMedian {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3};
        System.out.println(findMedianSortedArray(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];
        int k = 0;
        for(int i=0;i<merged.length;i++){
            if(i<n)
                merged[i] = nums1[i];
            else
                merged[i] = nums2[k++];
        }
        Arrays.sort(merged);
        int totalElements = merged.length;
        if(totalElements%2 == 1){
            return merged[totalElements/2];
        } else {
            return (double) (merged[(totalElements/2)-1] + merged[totalElements/2]) /2;
        }
    }

    public static double findMedianSortedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merged = new int[n+m];
        int k = 0;
        for(int i=0;i<merged.length;i++){
            if(i<n)
                merged[i] = nums1[i];
            else
                merged[i] = nums2[k++];
        }
        Arrays.sort(merged);
        int start = 0;
        int end = merged.length-1;
        for(int i=0;i<merged.length;i++) {
            if (start == end) {
                return merged[start];
            }else if(end-start==1){
                return (double) (merged[start]+merged[end])/2;
            }
            start++;
            end--;
        }
        return 0;
    }
}
