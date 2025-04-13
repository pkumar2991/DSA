package com.dsa.backtracking;

import java.util.*;

public class PermutationOfStringWithRecursion {
    /**
     * Given a string S. The task is to print all unique permutations of the given string in lexicographically sorted
     * order.
     *
     * Example 1:
     *
     * Input: ABC
     * Output:
     * ABC ACB BAC BCA CAB CBA
     * Explanation:
     * Given string ABC has permutations in 6
     * forms as ABC, ACB, BAC, BCA, CAB and CBA .
     * Example 2:
     *
     * Input: ABSG
     * Output:
     * ABGS ABSG AGBS AGSB ASBG ASGB BAGS
     * BASG BGAS BGSA BSAG BSGA GABS GASB
     * GBAS GBSA GSAB GSBA SABG SAGB SBAG
     * SBGA SGAB SGBA
     * Explanation:
     * Given string ABSG has 24 permutations.
     */
    static List<String> listOfPermutations = new ArrayList<>();
    public static void main(String[] args) {
        String input = "AABC";
        populatePermutationsOfString(input,"");
        System.out.println(listOfPermutations);
        listOfPermutations.clear();
        populatePermutationsUsingRecursion(input,"");
        System.out.println(listOfPermutations);
    }

    private static void populatePermutationsOfString(String input, String output) {
        // Base condition
        if(input.isEmpty()){
            listOfPermutations.add(output);
            return;
        }

        Set<Character> processedChar = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if(!processedChar.contains(input.charAt(i))){ // Controlled recursion
                processedChar.add(input.charAt(i));
                String newOutput = output + input.charAt(i);
                String newInput = removeChar(input,input.charAt(i));
                populatePermutationsOfString(newInput,newOutput);
            }
        }
    }

    private static void populatePermutationsUsingRecursion(String input, String output){
        if(input.isEmpty()){
            listOfPermutations.add(output);
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            String newOutput = output + input.charAt(i);
            String newInput = removeChar(input,input.charAt(i));
            populatePermutationsUsingRecursion(newInput,newOutput);
        }
    }
    static private String removeChar(String input, char ch){
        StringBuilder sb = new StringBuilder();
        int index = input.indexOf(ch);
        sb.append(input, 0, index);
        sb.append(input,index+1,input.length());
        return sb.toString();
    }


    public static class LargestNumberInKSwap {
        /**
         * Given a number K and string str of digits denoting a positive integer,
         * build the largest number possible by performing swap operations on the digits of str at most K times.
         * <p>
         * <p>
         * Example 1:
         * <p>
         * Input:
         * K = 4
         * str = "1234567"
         * Output:
         * 7654321
         */

        public static void main(String[] args) {
            String input = "1234";
            StringBuilder sb = new StringBuilder(input);
            int k = 2;
            StringBuilder maxNum = new StringBuilder(input);
            findLargestNum(sb, k, maxNum, 0);
            System.out.printf("Largest number: %s\n", maxNum);
        }

        private static void findLargestNum(StringBuilder sb, int k, StringBuilder maxNum, int start) {
            if (k == 0 || start == sb.length())
                return;
            for (int i = start + 1; i < sb.length(); i++) {
                if (isValid(sb, i, start)) {
                    swap(sb, start, i);
                    compareNumericStrings(sb, maxNum);
                    findLargestNum(sb, k - 1, maxNum, start + 1);
                    swap(sb, start, i);
                }
            }
            findLargestNum(sb, k, maxNum, start + 1);
        }

        private static void compareNumericStrings(StringBuilder strNum, StringBuilder maxNumSb) {
            StringBuilder sb = strNum.compareTo(maxNumSb) > 0 ? strNum : maxNumSb;
            maxNumSb.replace(0, maxNumSb.length(), sb.toString());
        }

        private static boolean isValid(StringBuilder sb, int index, int start) {
            OptionalInt optionalInt = sb.chars().max().stream().findFirst();
            if (optionalInt.isPresent()) {
                return sb.charAt(index) > sb.charAt(start) && sb.charAt(index) == optionalInt.getAsInt();
            }
            return false;
        }

        private static void swap(StringBuilder sb, int index1, int index2) {
            if (sb != null && sb.charAt(index1) != sb.charAt(index2)) {
                char temp = sb.charAt(index2);
                sb.setCharAt(index2, sb.charAt(index1));
                sb.setCharAt(index1, temp);
            }
        }
    }
}
