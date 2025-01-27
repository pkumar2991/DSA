package com.dsa.dynamicprogramming.mcm;

import java.util.Arrays;

public class FindMCMWithMemoization {
    /**
     * Matrix Chain Multiplication using Recursion
     *  Given a sequence of matrices, find the most efficient way to multiply these matrices together.
     *  The problem is not actually to  perform the multiplications, but merely to decide in which order
     *  to perform the multiplications.
     */
    private static int[][] t;
    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        t = new int[arr.length+1][arr.length+1];
        populateDefaultValue(t);
        int cost = findMinCostOfMCM(arr,1,arr.length-1);
        System.out.println("Minimum cost of MCM:" + cost);
    }
    static void populateDefaultValue(int[][] arr){
        for (int[] num : arr) {
            Arrays.fill(num, -1);
        }
    }
    static int findMinCostOfMCM(int[] arr, int i, int j){
        // arr must have two or more elements.
        if(i >= j){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempCost = findMinCostOfMCM(arr,i,k) + findMinCostOfMCM(arr,k+1,j)
                    + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,tempCost);

        }
        t[i][j] = min;
        return min;
    }
}