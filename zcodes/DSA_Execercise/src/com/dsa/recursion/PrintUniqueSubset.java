package com.dsa.recursion;

import java.util.LinkedHashSet;
import java.util.Set;

public class PrintUniqueSubset {
    /**
     * Substring
     * Subsequence
     * Subset
     *
     * If question asked to print subset or subsequence, always go with subsequence which is nothing but a subset.
     */

    public static void main(String[] args) {
        String str="aab";
        Set<String> set = new LinkedHashSet<>();
        printUniqueSubset(str,"",set);
        System.out.println(set);
    }

    private static void printUniqueSubset(String str, String op, Set<String> set) {
        if(str.length() == 0){
            set.add(op);
            return;
        }
        String op1= op;
        String op2 = op + str.substring(0,1);
        printUniqueSubset(str.substring(1),op1,set);
        printUniqueSubset(str.substring(1),op2,set);
    }
}
