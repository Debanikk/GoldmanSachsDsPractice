package com.wildfire.GoldmanSachsDsPractice.StockBuySell;

import java.util.HashMap;
import java.util.Map;

public class MaxProfitForStock {
    public static void main(String[] args) {
        int price[] = { 100, 180, 260, 310, 40, 535, 695 };
        //int price[] = { 7,1,5,3,6,4 };
        //int price[] = { 1,4,2 };
        int maxProfit =maxProfit(price); //calculateMaxProfit(price);
        int maxpf = maxProfitDays(price);
        System.out.println("Maximum amount profit with new method is - " + maxpf);
        System.out.println("Maximum amount profit is - " + maxProfit);
    }

    static int maxProfit(int[] price) {
        int buy_price = price[0];
        int profit = 0;
        for(int i = 1; i < price.length; i++) {
            if(price[i] < buy_price) {
                buy_price = price[i];
            }
            else {
                int currentProfit = price[i] - buy_price;
                profit = Math.max(currentProfit, profit);
            }
        }
        return profit;
    }

    static int maxProfitDays(int[] price) {
        Map<Integer, Integer> timeseries = new HashMap<>();
        int[] record = new int[3];
        int buy_price = price[0];
        int profit = 0;
        timeseries.put(price[0], 1);
        for(int i = 1; i < price.length; i++) {
            timeseries.put(price[i], i+1);
            if(price[i] < buy_price) {
                buy_price = price[i];
            }
            else {
                int currentProfit = price[i] - buy_price;
                if(currentProfit > profit) {
                    record[0] = currentProfit;
                    record[1] = timeseries.get(buy_price);
                    record[2] = i+1;
                }
                profit = Math.max(currentProfit, profit);
            }
        }
        System.out.println("The stock can be bought at day - " + record[1] + " and sold at day - " + record[2] + " with a profit of - " + record[0]);
        return profit;
    }

}
