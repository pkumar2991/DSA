package com.dsa.dynamicprogramming.knapsack;

public class TargetSumProblem {
    /**
     * Given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
     *
     * Find out how many ways to assign symbols to make sum of integers equal to target S.
     *
     * Example 1:
     * Input: nums is [1, 1, 1, 1, 1], S is 3.
     * Output: 5
     * Explanation:
     *
     * -1+1+1+1+1 = 3
     * +1-1+1+1+1 = 3
     * +1+1-1+1+1 = 3
     * +1+1+1-1+1 = 3
     * +1+1+1+1-1 = 3
     *
     * There are 5 ways to assign symbols to make the sum of nums be target 3.
     * s1 - s2 = diff
     */

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1};
        int sum = 3;
        int count = FindSubsetDiffCount.findSubSetDiffCount(arr,sum);
        System.out.println(count);
    }
}
