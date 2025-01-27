package com.dsa.dynamicprogramming.knapsack;

import java.util.Arrays;

public class FindSubsetDiffCount {
    /**
     * Given an array Arr[] and a difference diff,
     * find the number of subsets that array can be divided so
     * that each the difference between the two subset is the given diff.
     *
     * Example1:
     * Input:
     * Arr[] : 1,1,2,3
     * diff: 1
     * Output: 3 .
     */

    public static void main(String[] args) {
        int[] arr = {5,2,5}; int diff = 4;
        int count = findSubSetDiffCount(arr,diff);
        System.out.println(count);
    }

    public static int findSubSetDiffCount(int[] arr, int diff) {
        int sum = (diff + Arrays.stream(arr).sum())/2;
        return countSubSetSum(arr,sum);
    }

    private static int countSubSetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];
        initDPTable(t);
        populateDPTable(t,arr);
        return t[n][sum];
    }

    private static void populateDPTable(int[][] t, int[] arr) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] + t[i-1][j];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
    }

    private static void initDPTable(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j == 0){
                    t[i][j] = 1;
                }
            }
        }
    }

}
