package Scaler;

import java.util.HashMap;

public class MinNumberOfSquaresAddedToN {

    public static void main(String[] args) {
        int n=16;
        System.out.println(minNumberOfSquares(n));
    }

    /**
     * How this works.
     * For a number n the best way to find the number of squares that add up to is
     * ( 1+ min(minNumberOfSquares(n-x^2)) where x^2 <= n
     * Time =  O(n*Sqrt(n))
     * Space = O(n)
     */
    private static int minNumberOfSquares(int n){
        int[] dp = new int[1000000];
        dp[0]=0;
        for (int i=1; i <=n; i++){
            dp[i] = i;
            for (int x = 1; x*x<=i; x++){
                dp[i] = Math.min(dp[i], 1+dp[i-x*x]);
            }
        }
        return dp[n];
    }



}
