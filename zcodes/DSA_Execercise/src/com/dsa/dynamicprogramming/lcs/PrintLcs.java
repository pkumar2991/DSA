package com.dsa.dynamicprogramming.lcs;

public class PrintLcs {
    /**
     * Given two sequences, print the longest subsequence present in both of them.
     * Example:
     * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
     */

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";
        String lcs = getLcs(s1, s2);
        System.out.println("Longest Common Subsequence:" + lcs);
    }

    private static String getLcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] t = new int[n + 1][m + 1];
        initDpTable(t);
        populateDpTable(t, s1, s2);
        return buildLcs(t, s1, s2);
    }

    private static String buildLcs(int[][] t, String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        if (t != null) {
            int i = t.length - 1;
            int j = t[0].length - 1;
            while (i > 0 && j > 0){
                if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                    sb.append(s1.charAt(i-1));
                    i--;
                    j--;
                }else {
                    if(t[i][j-1] > t[i-1][j]){
                        j--;
                    }else {
                        i--;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }

    private static void populateDpTable(int[][] t, String s1, String s2) {
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }
    }

    private static void initDpTable(int[][] t) {
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0;
                }
            }
        }
    }
}
