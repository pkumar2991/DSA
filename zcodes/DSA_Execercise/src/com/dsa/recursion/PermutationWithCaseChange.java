package com.dsa.recursion;

public class PermutationWithCaseChange {
    /**
     * Print all permutations of a string keeping the sequence but changing cases.
     *
     * Examples:
     *
     * Input : ab
     * Output : AB Ab ab aB .
     *
     */

    public static void main(String[] args) {
        String str = "ab";
        printPermutation(str,"");
    }

    private static void printPermutation(String str, String op) {
        if(str.length() == 0){
            // leaf node
            System.out.printf("%s ",op);
            return;
        }
        String op1 = op + str.substring(0,1).toUpperCase();
        String op2 = op + str.substring(0,1);
        printPermutation(str.substring(1),op1);
        printPermutation(str.substring(1),op2);
    }
}
