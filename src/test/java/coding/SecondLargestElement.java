package coding;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr={15,17,16,18};
        System.out.println(findSecondLargest(arr));
    }

    static int findSecondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for(int num : arr){
            if(num>largest){
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            }else if(num>thirdLargest && num>secondLargest && num<largest){
                thirdLargest = num;
            }
        }
        return thirdLargest;
    }
}
