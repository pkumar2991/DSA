package com.dsa.binarysearch;

public class FindAnEltInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {15,23,32,12,14};
        int k = 23;
        int index = findElt(arr,0,arr.length-1,k);
        System.out.println("K found at: "+index);
    }

    private static int findElt(int[] arr, int start, int end, int k) {
        int minIndex = FindNoOfRotationOfSortedArray.findMinIndex(arr,start,end);
        if(minIndex >= 0 && arr[minIndex] == k){
            return minIndex;
        }
        int res = findIn(arr,start,minIndex-1,k);
        if(res == -1){
            return findIn(arr,minIndex+1,end,k);
        }
        return res;
    }

    private static int findIn(int[] arr, int start, int end,int k) {
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == k) return mid;
        if(arr[mid] < k){
            return findElt(arr,mid+1,end,k);
        }else{
            return findElt(arr,start,mid-1,k);
        }
    }
}
