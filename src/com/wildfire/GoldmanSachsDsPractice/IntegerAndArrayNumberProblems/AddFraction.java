package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

public class AddFraction {
    public static void main(String[] args) {
        int[] result = addFractions( new int[]{ 2, 3 }, new int[]{ 1, 2 } );

        if( result[ 0 ] == 7 && result[ 1 ] == 6 ) {
            System.out.println( "Test passed." );
        } else {
            System.out.println( "Test failed." );
        }
    }

    public static int[] addFractions(int[] frac1, int[] frac2){
        return (new int[]{frac1[1] * frac2[0] + frac1[0] * frac2[1], frac1[1] * frac2[1]});
    }
}
