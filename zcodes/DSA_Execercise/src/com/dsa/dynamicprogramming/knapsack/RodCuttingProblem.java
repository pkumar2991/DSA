package com.dsa.dynamicprogramming.knapsack;

import java.util.stream.IntStream;

public class RodCuttingProblem {
    /**
     * Given a rod of length n inches and an array of prices
     * that contains prices of all pieces of size smaller than n. Determine the
     * maximum value obtainable by cutting up the rod and selling the pieces.
     * Example:
     * if length of the rod is 8 and the values of different pieces are given as following,
     * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
     *
     *
     * length   | 1   2   3   4   5   6   7   8
     * --------------------------------------------
     * price    | 1   5   8   9  10  17  17  20
     */

    public static void main(String[] args) {
        int n = 3;
        int[] lenArr = IntStream.rangeClosed(1,n).toArray();
        int[] prices = {1,5,4};
        int maxProfit = findMaxProfit(lenArr,prices,n);
        System.out.println(maxProfit);
    }

    private static int findMaxProfit(int[] lenArr, int[] prices, int n) {
        int[][] t = new int[n+1][n+1];
        initDPTable(t);
        populateDPTable(t,lenArr,prices);
        return t[n][n];
    }

    private static void populateDPTable(int[][] t, int[] lenArr, int[] prices) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(lenArr[i-1] <= j){
                    t[i][j] = Math.max(prices[i-1] + t[i][j-lenArr[i-1]],t[i-1][j]);
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }

    private static void initDPTable(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i == 0 || j == 0){
                    t[i][j]=0;
                }
            }
        }
    }

}
