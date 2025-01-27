package com.dsa.dynamicprogramming.lcs;

public class $31FindSeqPatternMatching {
    /**
     * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
     *
     * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
     *
     * Example 1:
     * Input: s = "abc", t = "ahbgdc"
     * Output: true
     *
     * Example 2:
     * Input: s = "axc", t = "ahbgdc"
     * Output: false
     */

    public static void main(String[] args) {
        String s1= "abc";
        String s2="ahbgdc";
        int lcs = FindLcsWithDP.findLcsCount(s1,s2);
        System.out.println("Is sequence pattern matched: "+(s1.length() == lcs));
    }
}
