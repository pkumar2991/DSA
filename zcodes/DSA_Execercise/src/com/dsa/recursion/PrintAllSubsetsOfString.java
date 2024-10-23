package com.dsa.recursion;

public class PrintAllSubsetsOfString {
    /**
     * Print all subsets of a given string.
     * Example - abc , output- "",a,b,c,bc,ac,ab,abc
     */

    public static void main(String[] args) {
        String ip = "aab";
        String op = "";
        printSubsets(ip,op);
    }

    private static void printSubsets(String ip, String op) {
        if(ip.length() == 0){
            System.out.println(op+" ");
            return;
        }
        String op1 = op;
        String op2 = op + ip.substring(0,1);
        printSubsets(ip.substring(1),op1);
        printSubsets(ip.substring(1),op2);
    }
}
