package com.dsa.dynamicprogramming.knapsack;

public class SubSetSumProblem {

    /**
     * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set
     * with sum equal to given sum.
     * Example:
     *
     * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
     * Output:  True  //There is a subset (4, 5) with sum 9.
     */
    static Boolean[][] t = null;
    public static void main(String[] args) {
        int arr[] = {3, 34, 4, 12, 5, 2};
        int sum = 88;
        t = new Boolean[arr.length+1][sum+1];
        boolean isSubsetSumExist = findSubSetSum(arr,sum);
        System.out.println(isSubsetSumExist);
    }
    private static boolean findSubsetSumRecWithMemoization(int[] arr, int n, int sum) {
        if (n >= 0 && sum == 0) { // Empty set {}
            return true;
        }
        if(n == 0 && sum > 0){
            return false;
        }
        if(t[n][sum] != null){ // Memoization
            return t[n][sum];
        }
        if(arr[n-1] <= sum){
            t[n][sum] = findSubsetSumRecWithMemoization(arr,n-1,sum-arr[n-1]) || findSubsetSumRecWithMemoization(arr,n-1,sum);
        }else{
            t[n][sum] = findSubsetSumRecWithMemoization(arr,n-1,sum);
        }
        return t[n][sum];
    }

    private static boolean findSubsetSumRecursion(int[] arr, int n, int sum) {
        if (n >= 0 && sum == 0) { // Empty set {}
            return true;
        }
        if(n == 0 && sum > 0){
            return false;
        }
        if(arr[n-1] <= sum){
            return findSubsetSumRecursion(arr,n-1,sum-arr[n-1]) || findSubsetSumRecursion(arr,n-1,sum);
        }else{
            return findSubsetSumRecursion(arr,n-1,sum);
        }
    }
    private static boolean findSubSetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        initDPTable(t);
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(arr[i-1] <= j){
                    t[i][j] = t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    private static void initDPTable(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                if(i==0){
                    t[i][j] = false;
                }
                if(j==0){
                    t[i][j] = true;
                }
            }
        }
    }
}
