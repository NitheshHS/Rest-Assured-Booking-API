package coding;

import java.util.Arrays;
import java.util.List;

public class BuyStocks {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4,10};
        System.out.println(maxProfit(arr));
    }

    static int maxProfit(int[] arr){
       int minPrice = Integer.MAX_VALUE;
       int maxProfit = 0;
       for(int price: arr){
           if(price<minPrice){
               minPrice=price;
           }
           else{
               int profit = price - minPrice;
               if(profit>maxProfit){
                   maxProfit = profit;
               }
           }
       }
       return maxProfit;
    }
}
