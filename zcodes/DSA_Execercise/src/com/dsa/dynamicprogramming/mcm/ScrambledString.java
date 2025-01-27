package com.dsa.dynamicprogramming.mcm;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
    /**
     * Scramble String using Recursion
     * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
     * Below is one possible representation of A = “great”:
     *  great
     *    /    \
     *   gr    eat
     *  / \    /  \
     * g   r  e   at
     *            / \
     *           a   t
     * To scramble the string, we may choose any non-leaf node and swap its two children.
     *
     * For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.
     *
     *     rgeat
     *    /    \
     *   rg    eat
     *  / \    /  \
     * r   g  e   at
     *            / \
     *           a   t
     * We say that “rgeat” is a scrambled string of “great”.
     *
     * Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
     *
     *     rgtae
     *    /    \
     *   rg    tae
     *  / \    /  \
     * r   g  ta  e
     *        / \
     *       t   a
     * We say that “rgtae” is a scrambled string of “great”.
     */
    static Map<String,Boolean> dpMap = new HashMap<>();
    public static void main(String[] args) {
        String a = "great";
        String b = "rgate";
        if(!a.equals(b) || a.length() <= 1){
            System.out.println("Strings are scrambled.");
        }
        boolean isScrambled = findIfScrabledString(a,b);
        System.out.println("Are strings scrambled ? " +isScrambled);
    }

    private static boolean findIfScrabledString(String a, String b) {
        if(a.equals(b)){
            return true;
        }
        String key = a + " " + b;
        if(dpMap.containsKey(key)){ // Memoization
            return dpMap.get(key);
        }
        int n = a.length();
        boolean flag = false;
        for (int i = 1; i <= n-1; i++) {
            if( (findIfScrabledString(a.substring(0,i),b.substring(n-i,n)) && findIfScrabledString(a.substring(i,n),b.substring(0,n-i))) ||
                    (findIfScrabledString(a.substring(0,i),b.substring(0,i)) && findIfScrabledString(a.substring(i,n-1),b.substring(i,n-1)))){
                flag = true;
                break;
            }
        }
        dpMap.put(key,flag);
        return flag;
    }
}
