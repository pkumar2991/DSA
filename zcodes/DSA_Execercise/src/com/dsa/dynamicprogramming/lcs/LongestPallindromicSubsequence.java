package com.dsa.dynamicprogramming.lcs;

public class LongestPallindromicSubsequence {
    /**
     * Longest Palindromic Subsequence
     * Given a sequence, find the length of the longest palindromic subsequence in it.
     * Example :
     * Input:"bbbab"
     * Output:4
     */

    public static void main(String[] args) {
        String a = "agbcba";
        int count = FindLcsWithDP.findLcsCount(a,new StringBuilder(a).reverse().toString());
        System.out.println("Longest Pallindromic Subsequence Count: " + count);
    }
}
