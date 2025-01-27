package com.dsa.dynamicprogramming.lcs;

public class FindLongestCommonSubstringCount {
    /**
     * Longest Common Substring(Dynamic Programming)
     * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
     * Examples:
     *
     * Input : X = “GeeksforGeeks”, y = “GeeksQuiz”
     * Output : 5
     * The longest common substring is “Geeks” and is of length 5.
     */

    public static void main(String[] args) {
        String s1 = "abcde";
        String s2 = "abqd";
        int max = 0;
        int lcsCount = findLCSCount(s1,s2,s1.length(),s2.length(),max);
        System.out.println(lcsCount);
    }

    private static int findLCSCount(String s1, String s2, int n, int m,int count) {
        if(n == 0 || m == 0){
            return count;
        }
        int count2 = 0;
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            count = findLCSCount(s1,s2,n-1,m-1,count+1);
        }else{
            count2 = Math.max(findLCSCount(s1,s2,n,m-1,0), findLCSCount(s1,s2,n-1,m,0));
        }
        return Math.max(count,count2);
    }
}
