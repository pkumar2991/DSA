package com.dsa.dynamicprogramming.knapsack;

public class KnapSackTopDown {

    /**
     * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total
     * value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
     * and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
     * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal
     * to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
     *
     *
     * Time complexity - O(n*w)
     */

    public static void main(String[] args) {
        int[] wt ={1,2,1,3};
        int[] v = {1,2,4,1};
        int w = 5;
        int[][] t = new int[wt.length + 1][w+1];// t[n+1][w+1]
        initTopDownTable(t);
        int maxProfit = findMaxProfit(wt,v,t);
        System.out.println(maxProfit);

    }

    private static int findMaxProfit(int[] wt, int[] v, int[][] t) {
        int n = wt.length;
        int w = t[0].length;
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(wt[i-1] <= j)
                    t[i][j] = Math.max(v[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                else
                    t[i][j] = t[i-1][j];
            }
        }
        return t[n-1][w-1];
    }

    static void initTopDownTable(int[][] t){
        // Initialize with base condition
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i == 0 || j ==0){
                    t[i][j] = 0;
                }
            }
        }
    }

}
