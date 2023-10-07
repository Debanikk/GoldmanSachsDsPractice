package com.wildfire.GoldmanSachsDsPractice.StringOperations;


import java.util.ArrayList;

/// Pangram is a string which contains all the alphabets in it at least once.
/// Below program is created to detect the characters
/// which are missing from a string provided that will make it a Pangramic
public class MissingCharInPangramicString {
    public static void main(String[] args) {
        String str = "The quick brown fox jumps " +
                "over the dog";

        ArrayList<Character> missing = missingChars(
                str, str.length());

        if (missing.size() >= 1)
        {
            for(Character character : missing)
            {
                System.out.print(character);
            }
        }
    }

    static ArrayList<Character> missingChars(String str, int length){
        final int max_length = 26;
        ArrayList<Character> charList = new ArrayList<>();
        Boolean[] presentArr = new Boolean[max_length];

        for(int i = 0; i < length; i++){
            if('A' <= str.charAt(i) && str.charAt(i) <= 'Z')
                presentArr[str.charAt(i) - 'A'] = true;
            else if('a' <= str.charAt(i) && str.charAt(i) <= 'z')
                presentArr[str.charAt(i) - 'a'] = true;
        }

        for(int i = 0; i < max_length; i++){
            if(presentArr[i] == false)
                charList.add(((char)(i + 'a')));
        }
        return charList;
    }
}
