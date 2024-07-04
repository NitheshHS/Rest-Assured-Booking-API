package coding;

import java.util.Arrays;

public class ArrayRotation {
    //[1,2,3,4,5] -> [2,3,4,5,5]
    public static int[] rotate(int[] arr, int noOfRotation){
        for(int i=0;i<noOfRotation;i++){
            int firstElement = arr[0];
            for(int j=0;j<arr.length-1;j++){
                arr[j] = arr[j+1];
            }
            int lastIndex = arr.length-1;
            arr[lastIndex] = firstElement;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println(Arrays.toString(rotateMethod2(arr, 2)));
    }

    public static int[] rotateMethod2(int[]  arr, int noOfRotations){
        int[] tempArr = new int[arr.length];
        int index = 0;
        //store lastElements
        for(int i=noOfRotations;i<arr.length;i++){
            tempArr[index++]=arr[i];
        }
        //store firstElements
        for(int i=0;i<noOfRotations;i++){
            tempArr[index++] = arr[i];
        }
        return tempArr;
    }
}
