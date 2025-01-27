package com.dsa.dynamicprogramming.knapsack;

public class KnapsackWithMemoization {
    /**
     * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total
     * value in the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values
     * and weights associated with n items respectively. Also given an integer W which represents knapsack capacity,
     * find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal
     * to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
     */

    public static void main(String[] args) {
        int[] items ={1,2,1,3};
        int[] values = {1,2,4,1};
        int capacity = 5;
        int[][] t = new int[items.length+1][capacity+1];
        initMatrix(t);
        int max = findMaxProfit(items,values,t,capacity,items.length);
        System.out.println(max);
    }
    private static void initMatrix(int[][] t){
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                t[i][j] = -1;
            }
        }
    }

    private static int findMaxProfit(int[] items, int[] values,int[][] t, int capacity, int n) {
        if(n == 0 || capacity == 0)
            return 0;
        if(t[n][capacity] != -1) return t[n][capacity];
        if(items[n-1] <= capacity){
            int knapsackValue = values[n-1] + findMaxProfit(items,values,t,capacity-items[n-1],n-1);
            int knapsackValue1 = findMaxProfit(items,values,t,capacity,n-1);
            t[n][capacity] = Math.max(knapsackValue1,knapsackValue);
            return t[n][capacity];
        }else{
            t[n][capacity] = findMaxProfit(items,values,t,capacity,n-1);
            return t[n][capacity];
        }
    }
}
