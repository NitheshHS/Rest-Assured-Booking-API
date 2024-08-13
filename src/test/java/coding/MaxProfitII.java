package coding;

public class MaxProfitII {
    public static void main(String[] args) {
        int[] prices = {1,2,3,4,5};
        System.out.println(maxProfit(prices));
    }

    /*
    Input: prices = [7,1,5,3,6,4]
                               |
    //1; 1<7 true, minPrice = 1, start=1
    //2: 5<1 false, profit = 5-1 = 4, start=5
    //3: 3<5 true, minPrice = 3, start=3
    //4: 6<3 false, profit = 6-3=3, start=6
    //5: 4<6 false minPrice = 4


Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
     */

    /*
    {1,2,3,4,5}
    //1: 2>1, prof = 2-1=1
    //2: 3>2, prof = 1+1=2
     */
    public static int maxProfit(int[] prices) {
        int profit =0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        return profit;


//        int minPrice = 0;
//        int start = prices[0];
//        int profitSum = 0;
//        for(int i=1;i<prices.length;i++){
//            if(prices[i]<start) {
//                minPrice = prices[i];
//            }
//            else {
//                int profit = prices[i] - minPrice;
//                profitSum += profit;
//            }
//            start = prices[i];
//        }
//        return profitSum;
    }
}
