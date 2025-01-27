package com.dsa.dynamicprogramming.lcs;

public class FindLCSWithRecursion {
    /**
     * Longest Common Subsequence Problem solution using recursion
     * Given two sequences, find the length of longest subsequence present in both of them.
     * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
     * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
     */

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "qaeb";
        int lcsCount = findLCSCount(s1,s2,s1.length(),s2.length());
        System.out.println(lcsCount);
    }

    private static int findLCSCount(String s1, String s2, int n, int m) {
        if(n == 0 || m == 0){
            return 0;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1 + findLCSCount(s1,s2,n-1,m-1);
        }
        return Math.max(findLCSCount(s1,s2,n,m-1),findLCSCount(s1,s2,n-1,m));
    }
}
