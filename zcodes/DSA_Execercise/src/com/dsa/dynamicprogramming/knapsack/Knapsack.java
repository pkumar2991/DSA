package com.dsa.dynamicprogramming.knapsack;

public class Knapsack {
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
        int max = findMaxProfit(items,values,capacity,items.length);
        System.out.println(max);
    }

    private static int findMaxProfit(int[] items, int[] values, int capacity, int n) {
        if(n == 0 || capacity == 0)
            return 0;
        if(items[n-1] <= capacity){
            int knapsackValue = values[n-1] + findMaxProfit(items,values,capacity-items[n-1],n-1);
            int knapsackValue1 = findMaxProfit(items,values,capacity,n-1);
            return Math.max(knapsackValue1,knapsackValue);
        }else{
            return findMaxProfit(items,values,capacity,n-1);
        }
    }
}
