package com.wildfire.GoldmanSachsDsPractice.SmallestNumber;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LargestNumberFromArrayOfIntegers {
    public static void main(String[] args) {
        System.out.println("Largest Number test is successful : " + DoTests());
    }

    static Boolean DoTests(){
        Boolean result = Boolean.TRUE;
        Boolean res = findLargestNumber(Arrays.asList(1, 34, 3, 98, 9, 76, 45, 4)).equals("998764543431");
        if(res)
            return (result && findLargestNumber(Arrays.asList(7, 58, 87, 2, 16, 34, 54, 0, 90)).equals("908775854342160"));
        else
            return false;
    }

    static String findLargestNumber(List<Integer> nums){
        Collections.sort(nums, (a,b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        String result =  nums.stream().map(Object::toString).collect(Collectors.joining());
        return result;
    }
}
