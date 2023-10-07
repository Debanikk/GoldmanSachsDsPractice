package com.wildfire.GoldmanSachsDsPractice.ArrayRotationAndOtherSubArrayProblems;

public class VectorDotProduct {
    public static void main(String[] args) {
        int vect_A[] = { 3, -5, 4 };
        int vect_B[] = { 2, 6, 5 };
        System.out.println(DotProduct(vect_A, vect_B));
    }

    static int DotProduct(int vect_A[], int vect_B[]){
        int product = 0;
        int n = vect_A.length > vect_B.length ? vect_A.length : vect_B.length;
        for(int i = 0; i < n; i++){
            product = product + vect_A[i] * vect_B[i];
        }

        return product;
    }

    static void crossProduct(int vect_A[], int vect_B[],
                             int cross_P[])

    {
        cross_P[0] = vect_A[1] * vect_B[2]
                - vect_A[2] * vect_B[1];
        cross_P[1] = vect_A[2] * vect_B[0]
                - vect_A[0] * vect_B[2];
        cross_P[2] = vect_A[0] * vect_B[1]
                - vect_A[1] * vect_B[0];
    }
}
