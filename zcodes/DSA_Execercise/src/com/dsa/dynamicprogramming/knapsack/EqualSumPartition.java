package com.dsa.dynamicprogramming.knapsack;

import java.util.Arrays;

public class EqualSumPartition {
    /**
     * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
     * Examples:
     *
     * arr[] = {1, 5, 11, 5}
     * Output: true
     * The array can be partitioned as {1, 5, 5} and {11}
     *
     * Note: if the sum of elements of a set is even, then only the set can be split into two. Later, the problem
     * converted into another problem- Find subset sum of the given array.
     *
     * {1,5,11,5} and sum = 22
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 6}; // 2, 4, 6, 8, 14,
        boolean canBePartitioned=findEqualSumPartition(arr);
        System.out.println(canBePartitioned);
    }

    private static boolean findEqualSumPartition(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0){
            return false;
        }
        return findSubsetSum(arr,sum/2);
    }

    private static boolean findSubsetSum(int[] arr,int sum) {
        int n = arr.length;
        int w = sum;
        boolean t[][] = new boolean[n+1][w+1];

        initializeDPTable(t);
        populateDPTable(t,arr);
        return t[n][w];

    }

    private static void populateDPTable(boolean[][] t, int[] wt) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(wt[i-1] <= j){
                    t[i][j] = t[i-1][j-wt[i-1]] || t[i-1][j];
                }else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }

    private static void initializeDPTable(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(i == 0){
                    t[i][j] = false;
                }
                if(j == 0){
                    t[i][j] = true;
                }
            }
        }
    }


}
