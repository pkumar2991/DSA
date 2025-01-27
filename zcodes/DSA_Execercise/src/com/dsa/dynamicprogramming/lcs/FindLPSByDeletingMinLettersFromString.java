package com.dsa.dynamicprogramming.lcs;

public class FindLPSByDeletingMinLettersFromString {
    /**
     * Minimum number of deletions to make a string palindrome
     * Given a string of size ‘n’. The task is to remove or delete minimum number of characters from the string so that the resultant string is palindrome.
     * Examples :
     *
     * Input : aebcbda
     * Output : 2
     * Remove characters 'e' and 'd'
     * Resultant string will be 'abcba'
     * which is a palindromic string
     */

    public static void main(String[] args) {
        String a = "bbcb";
        int lpsCount = FindLcsWithDP.findLcsCount(a,new StringBuilder(a).reverse().toString());
        int minDeletion = a.length() - lpsCount;
        System.out.printf("Min deletion count: %d",minDeletion);
    }
}
