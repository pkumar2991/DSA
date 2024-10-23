package com.dsa.recursion;

public class TowerOfHanoi {
    /**
     * The tower of Hanoi is a famous puzzle where we have three rods and N disks.
     * The objective of the puzzle is to move the entire stack to another rod.
     * You are given the number of discs N. Initially, these discs are in the rod 1. You need to print
     * all the steps of discs movement so that all the discs reach the 3rd rod. Also, you need to find the total moves.
     */
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        String s ="A";
        String h = "B";
        String d = "C";

        moveDiscs(n,s,d,h);
        System.out.printf("Total count: %d \n",count);
    }

    private static void moveDiscs(int n, String s, String d, String h) {
        if(n == 1){
            print(n,s,d);
            return;
        }
        moveDiscs(n-1,s,h,d);
        print(n,s,d);
        moveDiscs(n-1,h,d,s);
    }

    static void print(int n, String source, String dest){
        count++;
        System.out.printf("Moving a disc %d from %s to %s \n",n,source,dest);
    }

}
