package coding;

public class StringSum {
    public static void main(String[] args) {
        sum("123","7");

    }

    static void sum(String str1, String str2){
        if(str1.length()<str2.length()){// 3<1->false
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        str1 = new StringBuilder(str1).reverse().toString();//321
        str2 = new StringBuilder(str2).reverse().toString();//7
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for(int i=0;i<str1.length();i++){
            int digit1 = str1.charAt(i) - '0';
            int digit2 = (i < str2.length())?str2.charAt(i)-'0':0;

            int sum = digit1+digit2+carry;
            carry = sum/10;
            result.append(sum%10);
        }
        if(carry>0)
            result.append(carry);

        System.out.println(result.reverse().toString());
    }
    //i=0, d1=3, d2=7, sum = 3+7+0=10, carry=1, result = 0
    //i=1, d1=2, d2=0, sum = 2+0+1=3,  carry=0, result = 03
    //i=2, d1=1, d2=0, sum = 1+0+0=1, carry=0, result=031
    //reverse result = 130
}
