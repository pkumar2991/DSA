package com.dsa.binarysearch;

public class FindPeakEltInUnsortedArray {

    /**
     * Array is unsorted and find the peak element.
     * Definition - P > left neighbour and right neighbour element
     *
     * Bitonic Array - It first increases and then decreases. Find the maximum value in the
     * array. This question is same as finding peak element in the given array.
     *
     * Concept - Binary Search on solutions
     */

    public static void main(String[] args) {
        int[] arr = {19,25,10,8,7,3,2};
        System.out.println(findElt(arr));
    }

    static int findElt(int[] arr){
        int start = 0;
        int end = arr.length - 1;
        if(arr.length == 0){
            return -1;
        }

        while (start <= end){
            int mid = start + ( end - start ) / 2;
            if(mid > 0 && mid < arr.length - 1){
                if(arr[mid] > arr[mid-1] && arr[mid+1] < arr[mid]){
                    return mid;
                }else if(arr[mid] < arr[mid +1]){
                    start = mid + 1;
                }else {
                    end = mid -1;
                }
            }else if(mid == 0){
                if(arr[mid] >= arr[mid + 1]){
                    return mid;
                }else{
                    return mid + 1;
                }
            }else if(mid == arr.length - 1){
                if(arr[mid] >= arr[mid -1]){
                    return mid;
                }else {
                    return mid + 1;
                }
            }
        }
        return -1;
    }
}
