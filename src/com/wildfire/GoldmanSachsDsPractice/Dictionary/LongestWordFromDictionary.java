package com.wildfire.GoldmanSachsDsPractice.Dictionary;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestWordFromDictionary {
    public static void main(String[] args) {
        if(DoTests()) {
            System.out.println("Pass");
        } else {
            System.err.println("Fails");
        }
    }

    static Boolean DoTests(){
        Dictionary dict = new Dictionary(new String[]{"to", "toe", "toes", "doe", "dog", "god", "dogs", "banana"});
        boolean r = new HashSet<String>(Arrays.asList("toe")).equals(longestWord("toe", dict));
        return r;
    }

    static Boolean isSubsequence(String str1, String str2){
        int m = str1.length(), n = str2.length();

        int j = 0; // For index of str1 (or subsequence)

        // Traverse str2 and str1, and compare current
        // character of str2 with first unmatched char
        // of str1, if matched then move ahead in str1
        for (int i = 0; i < n && j < m; i++)
        {
            if (str1.charAt(j) == str2.charAt(i))
            {
                j++;
            }
        }

        // If all characters of str1
        // were found in str2
        return (j == m);
    }

    // Time complexity - O(N*(K+n)) Here N is the length of dictionary
    // and n is the length of given string ‘word’ and K – maximum length of words in the dictionary.

    static Set<String> longestWord(String word, Dictionary dictionary){
        int length = 0;
        Set<String> result = new HashSet<>();
        String temp = "";
        for(String s: dictionary.entries){
            if(length < word.length() && isSubsequence(s, word)){
                temp = s;
                length = s.length();
            }
        }
        result.add(temp);
        return result;
    }

    /// Not needed as of now
    static HashMap<Character, Integer> getLetterCount(String word){
        HashMap<Character, Integer> letterCount = new HashMap<>();
        for(Character c: word.toCharArray()){
            if(letterCount.containsKey(c)){
                letterCount.replace(c, letterCount.get(c) + 1);
            }
            else{
                letterCount.put(c,1);
            }
        }
        return letterCount;
    }
}

class Dictionary{
    String[] entries;
    public Dictionary(String[] entries){
        this.entries = entries;
    }
    public Boolean contains(String word){
        return Arrays.asList(entries).contains(word);
    }
}
