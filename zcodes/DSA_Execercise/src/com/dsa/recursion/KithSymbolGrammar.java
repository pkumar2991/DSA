package com.dsa.recursion;

public class KithSymbolGrammar {
    /**
     * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and
     * replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
     *
     * Given row N and index K, return the K-th indexed symbol in row N.
     * (The values of K are 1-indexed.) (1 indexed).
     *
     * Notes:
     * 0
     * 0 1
     * 0 1 1 0
     * 0 1 1 0 1 0 0 1
     * Few observations:
     * -> No of elements in each row is doubled to the previous row.
     * -> First half of each row is equivalent to the previous row.
     * -> Second half of each row (if exist) is complement of the first half of the previous row.
     * -> Length of each row is increasing in power of base 2.
     */

    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        int res = findEltAtNthRow(n,k);
        System.out.println(res);
    }

    private static int findEltAtNthRow(int n, int k) {
        if(n == 0 && k == 1){
            return 0;
        }
        int mid = (int) Math.pow(2,n) / 2;
        if( k <= mid){
            return findEltAtNthRow(n-1,k);
        }else{
            return findEltAtNthRow(n-1,k-mid) == 0 ? 1 : 0;
        }
    }


}
