package com.wildfire.GoldmanSachsDsPractice.dynamicProgramming;

public class CoinExchangeSpaceOptimized {
    public static void main(String[] args) {
        int[] arr = {1, 5, 6, 9};
        int sum = 11;

        int result = getMinCoinsToExchange(arr, sum);
        System.out.println(String.format("The result is - %s", result));
    }

    private static int getMinCoinsToExchange(int[] arr, int amount) {
        int[] coinsReq = new int[amount + 1];

        for(int i = 0; i <= amount; i++) {
            coinsReq[i] = i;
        }

        for(int j = 1; j < arr.length; j++) {
            for(int i = 1; i <= amount; i++) {
                if( arr[j] <= i && (coinsReq[i - arr[j]] + 1 < coinsReq[i])) {
                    coinsReq[i] = coinsReq[i - arr[j]] + 1;
                }
            }
        }
        return coinsReq[amount];
    }
}
