package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateBalancedParenthesis {

    /**
     * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses of length 2*n.
     *
     * For example, given n = 3, a solution set is:
     *
     * "((()))", "(()())", "(())()", "()(())", "()()()" .
     *
     * Observation:
     * 1. If open and closing brackets are zero, then we get one result.
     * 2. Open brackets always being used until they are exhausted.
     * 3. Count of Close > Open, then close brackets are being used.
     */

    public static void main(String[] args) {
        int n = 2;
        int open = n;
        int close = n;
        List<String> output = new ArrayList<>();
        generateBalancedParenthesis(open,close,output,"");
        System.out.println(output);
    }

    private static void generateBalancedParenthesis(int open, int close, List<String> output, String op) {
        if(open == 0 && close == 0){
            output.add(op);
            return;
        }
        if(open != 0){
            String op1 = op + "(";
            generateBalancedParenthesis(open-1,close,output,op1);
        }
        if(close > open){
            String op2 = op + ")";
            generateBalancedParenthesis(open,close-1,output,op2);
        }
    }
}
