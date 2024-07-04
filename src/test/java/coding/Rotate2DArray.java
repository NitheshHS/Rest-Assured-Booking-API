package coding;

import java.util.Arrays;

public class Rotate2DArray {
    public static void main(String[] args) {
        //int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}}; //o/p: [[7,4,1],[8,5,2],[9,6,3]]
        int[][] matrix = {{5,1,9,11},
                        {2,4,8,10},
                        {13,3,6,7},
                        {15,14,12,16}};// [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
        int[][] tempArr = rotate90Degree(matrix);

        for(int i=0;i<tempArr.length;i++){
            System.out.print(Arrays.toString(tempArr[i])+", ");
        }
    }

    public static int[][] rotate90Degree(int[][] matrix){

        int[][] temp=new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            int k = matrix.length-1;
            for(int j=0;j<matrix[i].length;j++){
                temp[i][j] = matrix[k--][i];
//                matrix[0][1] = matrix[1][0];
//                matrix[0][2] = matrix[0][0];
            }
        }
        return temp;
    }
}
