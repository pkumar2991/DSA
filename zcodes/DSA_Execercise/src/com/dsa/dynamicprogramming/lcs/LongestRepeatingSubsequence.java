package com.dsa.dynamicprogramming.lcs;

public class LongestRepeatingSubsequence {
    /**
     * The problem of the Longest Repeating Subsequence asks us to find the length of the
     * longest subsequence in a string that appears at least twice, but without overlapping.
     *
     * For example:
     *
     * Input: AABEBCDD
     * Output: 3
     * Explanation: The longest repeating subsequence is ABD.
     */

    public static void main(String[] args) {
        String s1 = "AABEBCDD";
        String s2 = s1;
        int count = findSubLongestRepeatingSequence(s1,s2);
        System.out.println(count);
    }

    private static int findSubLongestRepeatingSequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] t = new int[n+1][m+1];
        initDpTable(t);
        populateDpTable(s1,s2,t);
        return t[n][m];
    }

    private static void populateDpTable(String s1, String s2, int[][] t) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(i != j && s1.charAt(i-1) == s2.charAt(j-1)){
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
                if(i == 0 || j == 0){
                    t[i][j] = 0;
                }
            }
        }
    }
}
