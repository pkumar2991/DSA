package com.dsa.binarysearch;

public class FindEltInInfiniteSortedArray {

    /**
     * Find an element in a infinite sorted array.
     * Real challenge - Can't calculate the end of the array.
     * Solution - Consider the second element itself as end element. If the search key greater than the end
     * element extend the end to twice of the existing index.
     * Note: As the array is the infinite array, end index will never cause the ArrayIndexOutOfBoundException.
     */

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,12,13,14,15,16,17};
        System.out.println(findElt(arr,14));
    }

    static int findElt(int[] arr,int key){
        int len = arr.length;
        if(len <= 1) return -1;
        int start = 0;
        int end = 1;

        while (key > arr[end]){
            start = end;
            end *= 2;
            // To fix the ArrayIndexOutOfBoundException although it's not needed if the input arr is infinite
            if(end > len){
                end = arr.length-1;
                break;
            }
        }


        return findEltInBoundedSortedArr(start,end,key,arr);
    }


    static int findEltInBoundedSortedArr(int start, int end, int key, int[] arr){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(key == arr[mid]){
            return mid;
        }else if(key > arr[mid]){
            return findEltInBoundedSortedArr(mid+1,end,key,arr);
        }else{
            return findEltInBoundedSortedArr(start,mid-1,key,arr);
        }
    }
}
