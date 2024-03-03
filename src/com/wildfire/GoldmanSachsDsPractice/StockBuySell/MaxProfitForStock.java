package com.wildfire.GoldmanSachsDsPractice.StockBuySell;

public class MaxProfitForStock {
    public static void main(String[] args) {
        //int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        //int price[] = { 7,1,5,3,6,4 };
        int price[] = { 1,4,2 };
        int n = price.length;

        // function call
        int maxProfit = calculateMaxProfit(price);
        System.out.println("Maximum amount profit is - " + maxProfit);
    }

    static int calculateMaxProfit(int[] prices) {
        int tsLength = prices.length;
        if(tsLength < 2 || tsLength > Math.pow(10,5))
            return 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices) {
            if(price < min) {
                min = price;
            }
            maxProfit = Math.max(maxProfit, price - min);
        }
        return maxProfit;

    }

    // this solution has a better runtime
    static int maxProfit(int[] prices) {
        int tsLength = prices.length;
        if(tsLength < 2 || tsLength > Math.pow(10,5))
            return 0;
        int min = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i = 0; i < tsLength; i++) {
            if(prices[i] < min) {
                min = prices[i];
            }
            else if(prices[i] - min > maxProfit) {
                maxProfit = prices[i] - min;
            }
        }
        return maxProfit;

    }

}
