package com.wildfire.GoldmanSachsDsPractice.groupAnagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args){
        String input = "cat dog tac sat tas god ";
        setOfAnagrams(input);
    }

    static void setOfAnagrams(String inputStr){
        HashMap<String, ArrayList<String>> ana = new HashMap<>();

        String[] words = inputStr.split(" ");
        for(String w : words){
            char[] cArr = w.toCharArray();
            Arrays.sort(cArr);
            String wSorted = new String(cArr);
            ArrayList<String> wList = new ArrayList<String>();
            if(!ana.containsKey(wSorted)){
                wList.add(w);
            }
            else{
                wList = ana.get(wSorted);
                wList.add(w);
            }
            ana.put(wSorted, wList);
        }

        //string concatenate and print the entire anagram string
        for(String s: ana.keySet()){
            if(ana.get(s).size() > 1){
                for(String word : ana.get(s)){
                    System.out.println(word + " ");
                }
            }
        }
    }
}
