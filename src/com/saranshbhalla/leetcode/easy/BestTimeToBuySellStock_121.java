package com.saranshbhalla.leetcode.easy;

public class BestTimeToBuySellStock_121 {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{2,1}));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        if(prices.length<2)
            return profit;

        int start=prices[0];
        for(int i=1;i<prices.length;i++){
            if(prices[i]<start)
                start=prices[i];
            else{
                profit = Math.max(profit, prices[i]-start);
            }
        }
        return profit;
    }
}
