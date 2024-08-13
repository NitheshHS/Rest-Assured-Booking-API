package coding;

public class MaxProfit {
    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }
/*
prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int price:prices){
            if(price<minPrice){
                minPrice = price;
            }
            else{
                int profit = price - minPrice;
                if(profit>maxProfit){
                    maxProfit = profit;
                }
            }
        }
        return maxProfit == Integer.MIN_VALUE?0:maxProfit;
    }
}

