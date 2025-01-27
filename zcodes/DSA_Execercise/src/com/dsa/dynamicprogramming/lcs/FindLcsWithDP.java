package com.dsa.dynamicprogramming.lcs;

public class FindLcsWithDP {

    /**
     * Longest Common Subsequence Problem solution using recursion
     * Given two sequences, find the length of longest subsequence present in both of them.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
     */
    static int[][] t;
    public static void main(String[] args) {
        String x = "My name is Prabhakar";
        String y = "Her name is Manisha";
        int countLcs = findLcsCount(x,y);
        System.out.println(countLcs);
    }

    public static int findLcsCount(String x, String y) {
        int n = x.length();
        int m = y.length();
        t = new int[n+1][m+1];
        initDpTable(t);
        populateDpTable(t,x,y);
        return t[n][m];
    }

    private static void populateDpTable(int[][] t, String x, String y) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j <t [i].length; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = Math.max(t[i][j-1],t[i-1][j]);
                }
            }
        }
    }

    private static void initDpTable(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if(i== 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
    }
}
