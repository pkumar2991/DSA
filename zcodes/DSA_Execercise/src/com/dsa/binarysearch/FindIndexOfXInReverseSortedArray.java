package com.dsa.binarysearch;

public class FindIndexOfXInReverseSortedArray {

    public static void main(String[] args) {
        int arr[]={12,10,4,3,2,1};
        int key = 13;
        int index = findIndex(arr,key);
        if(index >= 0)
            System.out.println(arr[index]);
        else
            System.out.println("Key does not exist");
    }

    public static int findIndex(int[] arr, int key){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] < key){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
}
