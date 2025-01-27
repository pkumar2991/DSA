package com.dsa.dynamicprogramming.lcs;

public class PrintShortestCommonSubsequence {
    /**
     * Given two strings X and Y, print the shortest string that has both X and Y
     * as subsequences. If multiple shortest supersequence exists, print any one of them.
     *
     * Examples:
     *
     * Input: X = "AGGTAB",  Y = "GXTXAYB"
     * Output: "AGXGTXAYB" OR "AGGXTXAYB"
     * OR Any string that represents shortest
     * supersequence of X and Y
     *
     * Input: X = "HELLO",  Y = "GEEK"
     * Output: "GEHEKLLO" OR "GHEEKLLO"
     * OR Any string that represents shortest
     * supersequence of X and Y
     */
    public static void main(String[] args) {
        String s1 = "HELLO";
        String s2 = "GEEK";
        String scs = findSCS(s1,s2);
        System.out.println(scs);
    }

    private static String findSCS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] t = new int[n+1][m+1];
        initDpTable(t);
        populateDpTable(t,s1,s2);
        return buildScsFromDpTable(t,s1,s2);
    }

    private static String buildScsFromDpTable(int[][] t,String s1,String s2) {
        if(t == null || t.length == 0)
            return null;
        StringBuilder scsSb = new StringBuilder();
        int i = t.length-1;
        int j = t[i].length - 1;
        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                scsSb.append(s1.charAt(i-1));
                i--;
                j--;
            } else {
                if (t[i][j - 1] > t[i-1][j]) {
                    scsSb.append(s2.charAt(j - 1));
                    j--;
                } else {
                    scsSb.append(s1.charAt(i - 1));
                    i--;
                }
            }
        }
        while (i > 0){
            scsSb.append(s1.charAt(i-1));
            i--;
        }
        while (j > 0){
            scsSb.append(s2.charAt(j-1));
            j--;
        }

        return scsSb.reverse().toString();
    }

    private static void populateDpTable(int[][] t, String s1, String s2) {
        if(t == null || t.length == 0)
            return;
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j < t[i].length; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
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
