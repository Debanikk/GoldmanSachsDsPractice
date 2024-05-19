package com.wildfire.GoldmanSachsDsPractice.PrimeFactorization;

public class KthFactorOfNSolution {
    public static void main(String[] args) {
        int n = 18;
        int k = 4;
        int result = kthFactor(n,k);
        System.out.println(String.format("The kth - %s factor of number - %s is - %s", k, n, result));
    }

    public static int kthFactor(int n, int k) {
        for(int i = 1; i * i < n; i++) {
            if(n % i == 0 && --k == 0)
                return i;
        }

        for(int i = (int)Math.sqrt(n); i >= 1; i--) {
            if(n % i == 0 && --k == 0)
                return n/i;
        }
        return -1;
    }
}
