package com.dsa.dynamicprogramming.lcs;

public class FindShortestCommonSuperseq {

    /**
     * Shortest Common SuperSequence
     * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
     * Examples:
     *
     * Input:   str1 = "geek",  str2 = "eke"
     * Output: "geeke"
     */

    public static void main(String[] args) {
        String s1 = "ABC";
        String s2 = "CDE";
        int count = s1.length() + s2.length() - FindLcsWithDP.findLcsCount(s1,s2);
        System.out.println(count);
    }
}
