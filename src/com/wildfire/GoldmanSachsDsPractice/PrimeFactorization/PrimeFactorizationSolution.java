package com.wildfire.GoldmanSachsDsPractice.PrimeFactorization;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeFactorizationSolution {

    public static void main(String[] args){
        /* System.out.println(primeFactorization(292));
        System.out.println(primeFactorization(315) + " " + primeFactorization(5));
        if(primeFactorization(42).equals(Arrays.asList(2,3,7))
                &&
                primeFactorization(5).equals(Arrays.asList(5))
        ) {
            System.out.println("All passed");
        } else {
            System.out.println("Failed");
        } */

        if(primeFactOptimized(42).equals(Arrays.asList(2,3,7)))
            System.out.println("Test Passed");
    }

    public static ArrayList<Integer> primeFactorization(int x)
    {
        ArrayList<Integer> primeFac = new ArrayList<Integer>();
        if(x < 2) {return primeFac;}
        if(x == 2) {
            primeFac.add(2);
            return primeFac;
        }
        int temp = x;
        for(int i = 2; i <= Math.sqrt(temp); i++) {
            if(x%i == 0) {
                primeFac.add(i);
                while(x % i == 0 && x > 1) {
                    x = x/i;
                }
            }
        }
        if(x > 2) {
            primeFac.add(x);
        }
        return primeFac;
    }


    static ArrayList<Integer> primeFactOptimized(int num){
        ArrayList<Integer> primeFacts = new ArrayList<>();
        int c = 2;
        if(num<2)
            return primeFacts;
        if(num == 2){
            primeFacts.add(2);
            return primeFacts;
        }
        while(num > 1){
            if(num % c == 0) {
                primeFacts.add(c);
                num = num/c;
            }
            else{
                c++;
            }
        }
        return primeFacts;
    }
}
