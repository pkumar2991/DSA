package com.dsa.binarysearch;

public class FindXInSortedArray {

    /*
    * Given a sorted array of n elements, write a function to search a given element x in the array
    * */

    public static void main(String[] args) {
        int[] arr = {1,10,12,15,24,26,26};
        int key = 26;
        boolean result = findXInSortedArray(arr,key);
        boolean recurringResult = findXInSortedArrayUsingRecur(arr,key,0, arr.length-1);
        System.out.println(result);
        System.out.println(recurringResult);
    }
    static boolean findXInSortedArray(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end -start) / 2;
            if(arr[mid] == key)
                return true;
            if(arr[mid] < key){
                mid++;
                start = mid;
            }else{
                mid--;
                end = mid;
            }
        }
        return false;
    }

    static boolean findXInSortedArrayUsingRecur(int[] arr, int key, int start, int end){

        if(arr.length == 0)
            throw new RuntimeException("Input data is empty.");
        if(start > end) return false;
        int mid = start + (end - start) / 2;
        if(arr[mid] == key){
            return true;
        }
        if(arr[mid] < key){
           return findXInSortedArrayUsingRecur(arr,key,mid+1,end);
        }else{
            return findXInSortedArrayUsingRecur(arr,key,start,mid - 1);
        }
    }


}
