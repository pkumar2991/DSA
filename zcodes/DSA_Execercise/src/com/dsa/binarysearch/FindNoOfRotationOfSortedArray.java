package com.dsa.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class FindNoOfRotationOfSortedArray {

    public static void main(String[] args) {
        int[] arr = {3,4,5,6,7,8,9,10,1,2};
//        int[] arr = {11,12,15,18,2,5,6,8};

        System.out.println(findMinIndex(arr,0,arr.length-1));
        System.out.println(findMinIndexRecursive(arr,0,arr.length-1));
    }

    static int findMinIndex(int[] arr, int start, int end){

        int n = arr.length;
        while (start <= end){
            if(arr[start] <= arr[end]){
                return start;
            }
            int mid = start + (end - start) / 2;
            int next = (mid + 1) % n;
            int prev = (mid + n -1) % n;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
                return mid;
            }else if(arr[start] <= arr[mid]){
                start = mid + 1;
            }else if(arr[mid] <= arr[end]){
                end = mid - 1;
            }
        }
        return -1;
    }
    static int findMinIndexRecursive(int[] arr, int start, int end){
        if(arr[start] <= arr[end]){
            return start;
        }
        int mid = start + (end - start) / 2;
        int n = arr.length;
        int next = (mid + 1) % n;
        int prev = (mid + n - 1) % n;

        if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]){
            return mid;
        }else if(arr[start] <= arr[mid]){
            return findMinIndexRecursive(arr,mid+1,end);
        }else if(arr[mid] <= arr[end]){
            return findMinIndexRecursive(arr,start,mid - 1);
        }else{
            return -1;
        }
    }
}
