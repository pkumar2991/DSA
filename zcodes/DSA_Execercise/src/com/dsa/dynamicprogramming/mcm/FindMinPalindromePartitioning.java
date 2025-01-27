package com.dsa.dynamicprogramming.mcm;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

public class FindMinPalindromePartitioning {
    /**
     * Given a string, a partitioning of the string is a palindrome partitioning if every substring of
     * the partition is a palindrome.
     */
    static int[][] dpTable;
    public static void main(String[] args) {
        String  str = "prakashhjhlkjkljlkkkkkkhhhhggttklklafdsthisisfornexonIlovemycardddx";
        int n = str.length();
        dpTable = new int[n+1][n+1];
        populateDpTable(dpTable);
        Instant start = Instant.now();
        int minPartitionCount = findMin(str,0,str.length()-1);
        Instant end = Instant.now();
        System.out.println("minPartitionCount:"+minPartitionCount);
        Duration timeElapsed = Duration.between(start,end);
        System.out.println("Time Elapsed: "+timeElapsed.toNanos());

        start = Instant.now();
        System.out.println("Optimized solution: "+findMinOptimized(str,0,str.length()-1));
        end = Instant.now();
        timeElapsed = Duration.between(start,end);
        System.out.println("Time Elapsed: "+timeElapsed.toNanos());
    }


    private static void populateDpTable(int[][] dpTable) {
        for (int[] num : dpTable){
            Arrays.fill(num,-1);
        }
    }


    static int findMin(String str,int i, int j){
        if(i >= j || isPalindrome(str,i,j)){
            return 0;
        }
        if(dpTable[i][j] != -1){
            return dpTable[i][j];
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j-1 ; k++) {
            int temp = findMin(str,i,k) + findMin(str,k+1,j) + 1;
            min = Math.min(temp,min);
        }
        dpTable[i][j] = min;
        return min;
    }

    static int findMinOptimized(String str,int i, int j){
        if(i >= j || isPalindrome(str,i,j)){
            return 0;
        }
        if(dpTable[i][j] != -1){
            return dpTable[i][j];
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k <= j-1 ; k++) {
            int left = 0;
            int right = 0;
            if(dpTable[i][k] != -1){
                left = dpTable[i][k];
            }else{
                left = findMin(str,i,k);
                dpTable[i][k] = left;
            }
            if(dpTable[k+1][j] != -1){
                right = dpTable[k+1][j];
            }else {
                right = findMin(str,k+1,j);
                dpTable[k+1][j] = right;
            }
            int temp = left + right + 1;
            min = Math.min(temp,min);
        }
        dpTable[i][j] = min;
        return min;
    }

    static boolean isPalindrome(String str, int i, int j){
        if(i >= j){
            return true;
        }
        if(str.charAt(i) != str.charAt(j)){
            return false;
        }
        return isPalindrome(str,i+1,j-1);
    }

}
