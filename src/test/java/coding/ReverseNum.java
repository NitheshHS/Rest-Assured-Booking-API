package coding;

public class ReverseNum {
    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }

    public static int reverse(int x) {
       boolean isNegative = x<0;
        String value = String.valueOf(Math.abs(x));
        String reversed = new StringBuffer(value).reverse().toString();
        int result =0;
        try {
             result = Integer.parseInt(reversed);
        }
        catch (NumberFormatException e){
            return result;
        }

        return isNegative?-result:result;
    }
}
