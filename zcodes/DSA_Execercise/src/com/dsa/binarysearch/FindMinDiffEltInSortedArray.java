package com.dsa.binarysearch;

public class FindMinDiffEltInSortedArray {

    /**
     * In the given array , find the element which has minimum absolute difference with the given key.
     *
     * 1,8,10,15 key - 12, output - 10
     *
     * Fact: If the key is present in the array, then the element itself would give the minimum absolute diff.
     * Otherwise,one of neighbour elements of the key would be eligible candidate for answers.
     */

    public static void main(String[] args) {
        int[] arr = {1,8,10,15,17};
        System.out.println(findElt(arr,0,arr.length-1,12));
    }

    static int findElt(int[] arr, int start, int end, int key){
        if(start > end){
            if(start > arr.length-1){ // when the key exist outside the array boundary
                return arr.length-1;
            }
            return Math.min(Math.abs(arr[start] - key),Math.abs(arr[end] -key));
        }
        int mid = start + (end - start) / 2;
        if(key == arr[mid])
            return mid;
        else if(key > arr[mid]){
            return findElt(arr,mid + 1, end,key);
        }else{
            return findElt(arr, start, mid - 1, key);
        }
    }
}
