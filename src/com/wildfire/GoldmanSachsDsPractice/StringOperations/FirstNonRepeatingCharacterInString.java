package com.wildfire.GoldmanSachsDsPractice.StringOperations;

import java.util.HashMap;

public class FirstNonRepeatingCharacterInString {
    public static void main(String[] args) {
        String[] inputs = {"apple", "racecars", "ababdc", "aabdcce"};
        char[] outputs = {'a', 'e', 'd', 'd' };

        boolean result = true;
        for(int i = 0; i < inputs.length; i++ )
        {
            result = result && findFirst(inputs[i]) == outputs[i];
            if(!result)
                System.out.println("Test failed for: " + inputs[i]);
            else
                System.out.println("Test passed for: " + inputs[i]);
        }
    }

    static char findFirst(String str){
        //Read the string and add char key and boolean values in hashmap
        // and update value as false for duplicate values if char contains in hashmap
        HashMap<Character, Boolean> charMap = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(charMap.containsKey(str.charAt(i))){
                charMap.replace(str.charAt(i), false);
            }
            else{
                charMap.put(str.charAt(i), Boolean.TRUE);
            }
        }

        //for each rotation check if hashmap value is true
        // then return character from running index in for loop
        for(int i = 0; i < str.length(); i++){
            if(charMap.get(str.charAt(i)))
                return str.charAt(i);
        }

        return '0';
    }
}
