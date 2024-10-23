package com.dsa.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PrintPermutationOfSpace {
    /**
     * Print permutation of space.
     * Input - ABC
     * Output - A_B_C, A_BC,AB_C,ABC
     */

    public static void main(String[] args) {
        String input = "ABC";
        printPermutation(input.substring(1),input.substring(0,1));
    }


    private static void printPermutation(String input,String output) {
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        String op1 = output + " "+input.charAt(0);
        String op2 = output + input.charAt(0);
        printPermutation(input.substring(1),op1);
        printPermutation(input.substring(1),op2);
    }


}
