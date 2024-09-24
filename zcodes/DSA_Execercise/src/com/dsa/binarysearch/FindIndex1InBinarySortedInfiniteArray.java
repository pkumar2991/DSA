package com.dsa.binarysearch;

public class FindIndex1InBinarySortedInfiniteArray {

    /**
     * This is a derived question from two questions:
     * 1. Find first occurrence of a number in the given array.
     * 2. Find an element in a given sorted infinite array.
     *
     * Note: This is sorted binary infinite array.
     *
     */
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,1};
        System.out.println(findElt(arr,1));
    }
    static int findElt(int[] arr, int key){
       int start = 0;
       int end = start + 1;

       while (key > arr[end]){
           start = end;
           end = end * 2;
           if(end > arr.length - 1){
               end = arr.length;
           }
       }
       return FindIndexOf1stOcurrOfANum.findEltRecursion(arr,start,end,key,-1);
    }
}
