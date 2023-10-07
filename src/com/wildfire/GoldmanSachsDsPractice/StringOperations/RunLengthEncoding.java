package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class RunLengthEncoding {
    public static void main(String[] args) {
        if("".equals(rle("")) &&
                "a1".equals(rle("a")) &&
                "a3".equals(rle("aaa")) &&
        "a3b1".equals(rle("aaab"))){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }
    }

    public static String rle(String input){
        if(input.length() == 0 || input == null)
            return "";

        int count = 0;
        StringBuilder sb = new StringBuilder();
        char pre = input.charAt(0);
        sb.append(pre);
        for(char c : input.toCharArray()){
            if(pre == c){

                count++;
            }
            else{
                sb.append(count);
                sb.append(c);
                pre = c;
                count = 1;
            }
        }
        //sb.append(pre);
        sb.append(count);
        return sb.toString();
    }
}
