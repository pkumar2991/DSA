package com.dsa.binarysearch;

public class FindCeilEltInSortedArray {
    /**
     * Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.
     *
     * Example:
     *
     * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
     * Output : 2
     * 2 is the largest element in arr[] smaller than 5.
     */

    public static void main(String[] args) {
        int[] arr = {6,7,8,10};
        int ceil = findElt(arr,0,arr.length-1,-1,5);
        System.out.println(ceil);
    }
    static int findElt(int[] arr, int start,int end, int ceil, int key){
        if(start > end) return ceil;
        int mid = start + (end - start)/2;
        if(arr[mid] < key){

            return findElt(arr,mid+1,end,ceil,key);
        }else{
            ceil=arr[mid];
            return findElt(arr,start,mid-1,ceil,key);
        }
    }
}


