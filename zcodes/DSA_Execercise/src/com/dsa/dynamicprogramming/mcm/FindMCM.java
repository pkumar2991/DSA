package com.dsa.dynamicprogramming.mcm;

public class FindMCM {
    /**
     * Matrix Chain Multiplication using Recursion
     *  Given a sequence of matrices, find the most efficient way to multiply these matrices together.
     *  The problem is not actually to  perform the multiplications, but merely to decide in which order
     *  to perform the multiplications.
     */

    public static void main(String[] args) {
        int[] arr = {40,20,30,10,30};
        int cost = findMinCostOfMCM(arr,1,arr.length-1);
        System.out.println("Minimum cost of MCM:" + cost);
    }
    static int findMinCostOfMCM(int[] arr, int i, int j){
        // arr must have two or more elements.
        if(i >= j){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int tempCost = findMinCostOfMCM(arr,i,k) + findMinCostOfMCM(arr,k+1,j)
                    + arr[i-1]*arr[k]*arr[j];
            min = Math.min(min,tempCost);
        }
        return min;
    }
}