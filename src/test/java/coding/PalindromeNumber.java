package coding;

public class PalindromeNumber {
    public static void main(String[] args) {
        int x = -121;
        System.out.println(isPalindromeStr(x));
    }
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int temp = x;
        int sum = 0;
        while(temp>0){
            int rem = temp % 10;
            sum = sum*10 + rem;
            temp = temp/10;
        }
        return x == sum;
    }

    static boolean isPalindromeStr(int x){
        if(x<0) return false;
        return new StringBuilder(x).reverse().toString().equals(String.valueOf(x));
    }

}
