package com.dsa.dynamicprogramming.knapsack;

public class CoinChangeProblem {
    /**
     * Coin Change Problem Maximum Number of ways
     * Given a value N, if we want to make change for N cents,
     * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
     * how many ways can we make the change? The order of coins doesn’t matter.
     * Example:
     * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}.
     * So output should be 4.
     */

    public static void main(String[] args) {
        int[] coins = {1, 5, 3};
        int sum = 4;
        int count = findMaxCount(coins, sum);
        System.out.println(count);
    }

    private static int findMaxCount(int[] coins, int sum) {
        int n = coins.length;
        int[][] t = new int[n + 1][sum + 1];
        initDpTable(t);
        populateDpTable(t, coins);
        return t[n][sum];
    }

    private static void populateDpTable(int[][] t, int[] coins) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(coins[i-1] <= j){
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }

    private static void initDpTable(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i == 0)
                    t[i][j] = 0;
                if (j == 0)
                    t[i][j] = 1;
            }
        }
    }


}
