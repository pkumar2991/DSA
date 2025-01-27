package com.dsa.dynamicprogramming.knapsack;

public class CountSubSetSum {
    /**
     * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
     * Example:
     *
     * Input: arr[] = {1, 2, 3, 3}, X = 6
     * Output: 3
     * All the possible subsets are {1, 2, 3},
     * {1, 2, 3} and {3, 3}
     */

    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum = 10;
        int count = findCountSubsetSum(arr,sum);
        System.out.println(count);
    }

    private static int findCountSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int t[][] = new int[n+1][sum+1];
        initDPTable(t);
        populateDPTable(t,arr);
        return t[n][sum];
    }

    private static void populateDPTable(int[][] t, int[] arr) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
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
            for (int j = 0; j < t[0].length; j++) {
                if(i == 0){
                    t[i][j] = 0;
                }
                if(j==0){
                    t[i][j] = 1;
                }
            }
        }
    }
}
