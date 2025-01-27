package com.dsa.dynamicprogramming.lcs;

import java.util.Arrays;

public class FindLcsWithMemoization {
    /**
     * Longest Common Subsequence Problem solution using recursion
     * Given two sequences, find the length of longest subsequence present in both of them.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
     */
    private static int[][] t;
    public static void main(String[] args) {
        String x = "abc";
        String y = "qar";
        t = new int[x.length() + 1][y.length()+1];
        initDpTable(t);
        int count = findLcsCount(x,y,x.length(),y.length());
        System.out.println(count);
    }

    private static void initDpTable(int[][] t) {
        for (int[] arr : t) {
            Arrays.fill(arr, -1);
        }
    }

    private static int findLcsCount(String x, String y, int n, int m) {
        if(n == 0 || m == 0){
            return 0;
        }
        if(t[n][m] != -1){
            return t[n][m];
        }
        if(x.charAt(n-1) == y.charAt(m-1)){
            t[n][m] = 1 + findLcsCount(x,y,n-1,m-1);
        }else{
            t[n][m] = Math.max(findLcsCount(x,y,n,m-1),findLcsCount(x,y,n-1,m));
        }
        return t[n][m];
    }
}
