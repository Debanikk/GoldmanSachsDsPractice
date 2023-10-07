package com.wildfire.GoldmanSachsDsPractice.StringOperations;

public class characterCountEncoding {
    public static void main(String[] args) {
        if(DoTests())
        {
            System.out.println("Test passed");
        }
        else{
            System.out.println("Test Failed");
        }
    }

    static Boolean DoTests(){
        Boolean result = true;
        result = result && getEncodedString("SSSSSTTPPQ").equals("5S2T2P1Q");
        return result;
    }

    static String getEncodedString(String input){
        //Base case needs to be handled
        if(input.length() < 2)
            return "1" + input.charAt(0);

        StringBuilder sb = new StringBuilder();
        int count = 1;
        char lastChar = input.charAt(0);

        for(int i = 1; i<input.length(); i++){
            if(lastChar == input.charAt(i)){
                count++;
            }
            else{
                sb.append(count);
                sb.append(lastChar);
                lastChar = input.charAt(i);
                count = 1;
            }
        }

        sb.append(count);
        sb.append(lastChar);
        System.out.println(sb.toString());

        return sb.toString();
    }
}
