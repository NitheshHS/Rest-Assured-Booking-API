package coding;

import org.hamcrest.Matchers;

import java.util.ArrayList;
import java.util.List;

public class SubArraySum {
    public static void main(String[] args) {
        int[] arr={1,2,3,7,5};// [1,2,3,7,5], n = 5, s = 12
        System.out.println(subarraySum(arr, arr.length, 5));
    }

    // 1 2 3 4 5 6         11
    //         | |
    public static List<Integer> subarraySum(int[] arr, int n, int s) {
        int left = 0;
        int right = 1;
        int sum = arr[0] + arr[1];
        int minLen = 2;
        if (s == sum) {
            return List.of(0, 1);
        }

        while (left < n && right < n) {
            if (sum > s) {
                sum -= arr[left++];
            } else if (sum == s) {
                minLen = Math.min(minLen, (right - left + 1));
                sum -= arr[left++];
            } else {
               right++;
               sum += arr[right];
            }
        }

        return List.of(left, right);
    }
}
