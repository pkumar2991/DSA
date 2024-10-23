package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintNBitBinaryNoHaveMore1s {
    /**
     * Given a positive integer N, print all N bit binary numbers having more or equal 1’s than 0’s for any prefix of the number.
     *
     * Input:
     * 2
     * 2
     * 3
     * Output:
     * 11 10
     * 111 110 101 .
     * ------------------------------------------------------------------------------------------
     */

    public static void main(String[] args) {
        int n = 2;
        int one = 0;
        int zero = 0;

        List<String> result = new ArrayList<>();
        printNBitBinary(one,zero,n,result,"");
        System.out.println(result);

    }

    private static void printNBitBinary(int one, int zero, int n, List<String> result, String op) {
        if(n == 0){
            result.add(op);
            return;
        }
        String op1 = op + "1";
        printNBitBinary(one+1,zero,n-1,result,op1);
        if(one > zero){
            String op2 = op + "0";
            printNBitBinary(one,zero+1,n-1,result,op2);
        }
    }
}
