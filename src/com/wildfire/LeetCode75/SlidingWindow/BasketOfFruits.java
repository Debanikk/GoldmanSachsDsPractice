package com.wildfire.LeetCode75.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class BasketOfFruits {
    public static void main(String[] args) {
        int[] arr = {1,2,1,1,3,4,2,2,2,2,4};
        System.out.printf("The maximum contiguous sub array length where only 2 fruits can be put in the basket is - " + getTotalFruits(arr));
    }

    private static int getTotalFruits(int[] fruits) {
        int left = 0, right = 0, maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        for(right = 0; right < fruits.length; right++) {
            // add current Item in basket Map with value as the count of the item
            int currentCount = basket.getOrDefault(fruits[right], 0);
            basket.put(fruits[right], currentCount + 1);

            // now check if the basket has more than k elements which is 2 for us,
            // then start emptying the basket as per the order of addition

            while((basket.size() > 2)) {
                int fruitCount = basket.get(fruits[left]);
                if(fruitCount == 1) {
                    basket.remove(fruits[left]);
                }
                else {
                    basket.put(fruits[left], fruitCount - 1);
                }
                left++; // This will fetch us the next fruit from fruits array to remove from basket and help to create another sub array and mark the start of its index
            }
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        System.out.println("sub array start is -" + left);
        System.out.println("sub array end is -" + (right - 1));
        return maxFruits;
    }
}
