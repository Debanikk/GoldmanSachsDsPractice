package com.wildfire.GoldmanSachsDsPractice.IntegerAndArrayNumberProblems;

public class SquareRootSolution {
    public static void main(String[] args) {
        double[] inputs = {2, 4, 100};
        double[] expected_values = { 1.41421, 2, 10 };
        double threshold = 0.001;
        for(int i=0; i < inputs.length; i++)
        {
            if( Math.abs(squareRoot(inputs[i])-expected_values[i])>threshold )
            {
                System.out.printf( "Test failed for %f, expected=%f, actual=%f\n", inputs[i], expected_values[i], squareRoot(inputs[i]) );
            }
        }
        System.out.println( "All tests passed");

        for(int i = 0; i < inputs.length; i++){
            if((findSqRtUsingNewtonsMethod(inputs[i], threshold) - expected_values[i]) < 0.00001){
                System.out.println("'Test Success for value - " + inputs[i]);
            }
        }
    }

    public static double squareRoot( double x )
    {
        return findSqrt(x, 0, x);
    }

    private static double findSqrt(double x, double min, double max) {
        double mid = (max + min) / 2;
        double midsq = mid*mid;
        if(midsq < x + 0.001 && midsq > x - 0.001) {
            return mid;
        }
        else if( midsq > x + 0.001) {
            return findSqrt(x, min, mid);
        }
        else {
            return findSqrt(x, mid, max);
        }
    }

    static Double findSqRtUsingNewtonsMethod(double n, double l){
        //assuming the sqrt of na as n only
        double x = n;
        double root;
        int count = 0;

        while(true){
            count++;
            // calculate more close of x
            root = 0.5 * (x + (n/x));

            // check for closeness
            if(Math.abs(root - x) < l)
                break;
            x = root;
        }
        return root;

    }

}
