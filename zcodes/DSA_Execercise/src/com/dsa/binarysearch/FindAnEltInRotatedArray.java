package com.dsa.binarysearch;

public class FindAnEltInRotatedArray {

    public static void main(String[] args) {
        int[] arr = {15,23,32,12,14};
        int minEltIndex = FindNoOfRotationOfSortedArray.findMinIndex(arr,0,arr.length-1);
        int key = 32;
        int res = findElt(arr,0,minEltIndex - 1,key);
        int res1 = findElt(arr,minEltIndex + 1, arr.length-1, key);
        if(res >= 0)
            System.out.println(res);
        else if(res1 >=0)
            System.out.println(res1);
        else {
            System.out.println("Number not found.");
        }
    }

    public static int findElt(int[] arr, int start, int end,int key){
        if(start > end) return -1;
        int mid = start + (end - start) / 2;
        if(arr[mid] == key)
            return mid;
        if(key < arr[mid]){
            return findElt(arr,start,mid-1,key);
        }else {
            return findElt(arr,mid+1,end,key);
        }
    }
}
