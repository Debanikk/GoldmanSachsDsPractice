package com.wildfire.GoldmanSachsDsPractice.StringOperations;

import java.util.Scanner;

public class StringReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter a value for reversing it - ");
        String str = sc.nextLine();

        System.out.println(reverseStr(str));
    }

    public static String reverseStr( String str ){
        char[] chrArr = str.toCharArray();

        if(chrArr.length < 1)
            return "";

        StringBuilder sb = new StringBuilder();
        for(int i = chrArr.length - 1; i >=0; i--){
            sb.append(chrArr[i]);
        }
        return sb.toString();
    }
}
