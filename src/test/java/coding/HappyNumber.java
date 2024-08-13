package coding;

import java.util.HashSet;

public class HappyNumber {
    public static void main(String[] args) {
        int num=2;
        System.out.println(happyNum(num));
    }

    static boolean happyNum(int num){
        HashSet<Integer> numSet=new HashSet<>();
        while(num!=1 && !numSet.contains(num)){
            numSet.add(num);
            num = getSquareNum(num);
        }
        return num==1;
    }


    static int getSquareNum(int num){
        int sum=0;
        while(num > 0){
            int digit = num%10;
            sum += digit*digit;
            num = num/10;
        }
        return sum;
    }
}
