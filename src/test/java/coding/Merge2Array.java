package coding;

import java.util.Arrays;

public class Merge2Array {
    public static void main(String[] args) {
        int[] input1={10,12,14,16};
        int[] input2={11,13,15,17};
        //[10,1,20,2,30,3]
        System.out.println(Arrays.toString(mergeArray(input1, input2)));

    }

    public static int[] mergeArray(int[] input1, int[] input2){
        int[] mergeArr=new int[input1.length+input2.length];
        int p1=0;
        int p2=0;
        for(int i=0;i<mergeArr.length;i++){
            if(i%2==0){
                mergeArr[i]=input1[p1++];
            }else{
                mergeArr[i]=input2[p2++];
            }
        }
        return mergeArr;
    }
}
