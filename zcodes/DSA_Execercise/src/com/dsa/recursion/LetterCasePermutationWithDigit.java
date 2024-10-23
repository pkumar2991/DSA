package com.dsa.recursion;

public class LetterCasePermutationWithDigit {
    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
     * <p>
     * Examples:
     * Input: S = "a1b2"
     * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
     * <p>
     * Input: S = "3z4"
     * Output: ["3z4", "3Z4"]
     * <p>
     * Input: S = "12345"
     * Output: ["12345"] .
     */

    public static void main(String[] args) {
        String str = "123a";
        printPermutation(str, "");
    }

    private static void printPermutation(String str, String op) {
        if (str.length() == 0) {
            System.out.printf("%s ", op);
            return;
        }
        char firstChar = str.charAt(0);
        String op1 = "";
        String op2 = "";

        if (Character.isAlphabetic(firstChar)) {
            op1 = op + Character.toLowerCase(firstChar);
            op2 = op + Character.toUpperCase(firstChar);
            printPermutation(str.substring(1),op1);
            printPermutation(str.substring(1),op2);
        } else {
            op = op + firstChar;
            printPermutation(str.substring(1),op);
        }
    }
}
