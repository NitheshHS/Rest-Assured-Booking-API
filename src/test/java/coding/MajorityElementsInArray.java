package coding;

public class MajorityElementsInArray {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2,1,1,1,1,1,1};
        majority(nums);
    }

    public static void majority(int[] arr){
        int majorityElement = arr[0];
        int prevCount = 0;
        for(int i=0;i<arr.length;i++){
            int count=1;
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]){
                    count++;
                }
            }
            if(count>prevCount) {
                prevCount = count;
                majorityElement = arr[i];
            }
        }
        System.out.println("count: "+prevCount);
        System.out.println(majorityElement);
    }
}
