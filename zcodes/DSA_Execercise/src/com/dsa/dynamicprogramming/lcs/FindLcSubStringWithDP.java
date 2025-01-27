package com.dsa.dynamicprogramming.lcs;

public class FindLcSubStringWithDP {

    /**
     * Longest Common Substring(Dynamic Programming)
     * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
     * Examples:
     *
     * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
     * Output : 5
     * The longest common substring is “Geeks” and is of length 5.
     */
    static int[][] t;
    public static void main(String[] args) {
        String x = "abcde";
        String y = "ace";
        int countLcs = findLcSubstringCount(x,y);
        System.out.println(countLcs);
    }

    private static int findLcSubstringCount(String x, String y) {
        int n = x.length();
        int m = y.length();
        t = new int[n+1][m+1];
        initDpTable(t);
        return findMax(t,x,y);
    }

    private static int findMax(int[][] t, String x, String y) {
        int max = 0;
        for (int i = 1; i < t.length; i++) {
            for (int j = 1; j <t [i].length; j++) {
                if(x.charAt(i-1) == y.charAt(j-1)){
                    t[i][j] = 1 + t[i-1][j-1];
                }else{
                    t[i][j] = 0;
                }
                max = Math.max(max,t[i][j]);
            }
        }
        return max;
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
