package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class IntegerToRomanConvert {
    public static void main(String[] args) {

    }

    public static String intToRoman(int num) {
        if(num < 1 && num > 3999) {
            return "";
        }

        int[] valArr = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < valArr.length; i++) {
            while(num >= valArr[i]) {
                num -= valArr[i];
                sb.append(romanLiterals[i]);
            }
        }

        return sb.toString();
    }

}
