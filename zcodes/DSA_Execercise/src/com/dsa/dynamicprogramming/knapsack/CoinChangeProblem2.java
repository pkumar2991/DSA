package com.dsa.dynamicprogramming.knapsack;

public class CoinChangeProblem2 {
    /**
     * Coin Change Problem Minimum Numbers of coins
     * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
     * Example:
     *
     * Input: coins[] = {25, 10, 5}, V = 30
     * Output: Minimum 2 coins required
     * We can use one coin of 25 cents and one of 5 cents
     */

    public static void main(String[] args) {
        int[] coins = {5,1,2,10};
        int sum = 4;
        int minCount = findMinCoinCount(coins,sum);
        System.out.println(minCount);
    }

    private static int findMinCoinCount(int[] coins, int sum) {
        int n = coins.length;
        int[][] t = new int[n+1][sum+1];
        initDPTable(t);
        initDPTable2Row(t,coins);
        populateDPTable(t,coins);
        return t[n][sum];
    }

    private static void populateDPTable(int[][] t, int[] coins) {
        for (int i = 2; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]],t[i-1][j]);
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }

    private static void initDPTable2Row(int[][] t, int[] coins) {
        // Init Second row except first column
        int i = 1;
        for (int j = 1; j < t[i].length; j++) {
            if(j % coins[0] == 0){
                t[i][j] = j / coins[0];
            }else{
                t[i][j] = Integer.MAX_VALUE - 1;
            }
        }
    }

    private static void initDPTable(int[][] t) {
        // Init first row and first column
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i == 0){
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
                if(j == 0 && i > 0){
                    t[i][j] = 0;
                }
            }
        }
    }
}
