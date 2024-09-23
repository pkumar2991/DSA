package com.dsa.binarysearch;

public class FindAnEltInNearlySortedArray {
    /**
     * Definition - Unlike sorted array, an element in nearly sorted array could be available
     * at i-1 or i+1 positions.
     * 5,10,30,20,40
     */

    public static void main(String[] args) {
        int[] arr={5,10,30,20,40};
        int index = findElt(arr,0,arr.length-1,11);
        System.out.println(index);
    }
    static int findElt(int[] arr, int start, int end, int key){
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if (arr[mid] == key){
            return mid;
        }else if(mid - 1 > start && arr[mid-1] == key ){
            return mid-1;
        }else if(mid + 1 < end && arr[mid + 1] == key){
            return mid+1;
        }
        if(arr[mid] > key){
            return findElt(arr,start,mid-2,key);
        }else {
            return findElt(arr, mid + 2,end,key);
        }
    }
}
