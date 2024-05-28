package com.wildfire.LeetCode75.SlidingWindow;


import java.util.HashMap;

/** PROBLEM STATEMENT
 * Given a string "ABCBCDDFFEEEERT", find the contiguous sub array
 * with maximum length which can have at most two distinct characters.
 * For this string it will be - "FFEEEE" **/
public class SubStringWithKDistinctCharacter {
    public static void main(String[] args) {
        String text = "ABBBCCCBCDDFFEEEERT";
        int maxCharAllowed = 3;

        System.out.println("Maximum sub array length with maxCharAllowed - " + maxCharAllowed + " is - " + getMaxLengthContiguousSubArray(text, maxCharAllowed));
    }

    private static int getMaxLengthContiguousSubArray(String text, int maxCharAllowed){
        char[] charArray = text.toCharArray();
        int left = 0, right = 0, maxLen = 0;
        HashMap<Character, Integer> charMap = new HashMap<>();

        for(right = 0; right < charArray.length; right++) {
            // add current Item in character Map with value as the count of the item
            int currentCount = charMap.getOrDefault(charArray[right], 0);
            charMap.put(charArray[right], currentCount + 1);

            // now check if the basket has more than k elements which is 2 for us,
            // then start emptying the basket as per the order of addition
            while(charMap.size() > maxCharAllowed) {
                int charCount = charMap.get(charArray[left]);
                if(charCount == 1) {
                    charMap.remove(charArray[left]);
                }
                else {
                    charMap.put(charArray[left], charCount - 1);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
