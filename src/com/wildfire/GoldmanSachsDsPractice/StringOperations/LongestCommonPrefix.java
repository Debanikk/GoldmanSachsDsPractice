package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class LongestCommonPrefix {
    public static void main(String[] args) {

        String myStr = "Hello planet earth, you are a great planet.";
        System.out.println(myStr.indexOf("earth"));


        String[] arr = {"flower", "flow", "floght", "florida"};
        String res = getLongestCommonPrefix(arr);
        System.out.println("Longest common prefix is: " + res);
    }

    public static String getLongestCommonPrefix(String[] arr) {
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            while (arr[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
