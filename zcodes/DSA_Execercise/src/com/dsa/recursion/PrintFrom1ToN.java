package com.dsa.recursion;

public class PrintFrom1ToN {

    /**
     * Print numbers from 1 to N
     */

    public static void main(String[] args) {
        print(10,1);
    }

    static void print(int max,int num){
        if(num > max)
            return;
        System.out.format("%d ,",num++);
        print(max,num);
    }

}
