package com.dsa.dynamicprogramming.knapsack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSubSetSumDiff {

    /**
     * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.
     * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
     * <p>
     * Example:
     * Input:  arr[] = {1, 6, 11, 5}
     * Output: 1
     * Explanation:
     * Subset1 = {1, 5, 6}, sum of Subset1 = 12
     * Subset2 = {11}, sum of Subset2 = 11
     * S1 - (Range - S2)
     * Range-2s1=min diff
     */

    public static void main(String[] args) {
        int[] arr = {5,2,6,4};
        int min = findSubSetSumMinDiff(arr);
        System.out.println(min);
    }

    private static int findSubSetSumMinDiff(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        boolean[] t = findSubsetSum(arr,sum);
        int min = Integer.MAX_VALUE;
        List<Integer> sumLineList = new ArrayList<>();
        populateSumLine(sumLineList,t);
        for (int num:sumLineList) {
            min = Math.min(Math.abs(sum - 2*num),min);
        }
        return min;
    }

    private static void populateSumLine(List<Integer> sumLineList, boolean[] t) {
        for (int i = 0; i <= t.length / 2; i++) {
            if(t[i]){
                sumLineList.add(i);
            }
        }
    }

    private static boolean[] findSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];
        initDPTable(t);
        populateDPTable(t,arr);
        return t[n];
    }

    private static void populateDPTable(boolean[][] t, int[] arr) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[0].length; j++) {
                if(arr[i-1] <= j){
                    t[i][j]= t[i-1][j-arr[i-1]] || t[i-1][j];
                }else {
                    t[i][j]= t[i-1][j];
                }
            }
        }
    }

    private static void initDPTable(boolean[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i == 0)
                    t[i][j] = false;
                if(j==0)
                    t[i][j] = true;
            }
        }
    }
}
