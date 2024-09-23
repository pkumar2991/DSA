package com.dsa.binarysearch;

public class FindIndexOf1stOcurrOfANum {

    public static void main(String[] args) {
        int arr[] = {1,2,3,10,10,12,12,12,14,16};
        int res = findIndexOf1stOccurr(arr,12);
        System.out.println(res);
        System.out.println(arr[res]);
    }

    static int findIndexOf1stOccurr(int[] arr,int key){
        int start = 0;
        int end = arr.length - 1;
        int res = -1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] == key){
                res = mid;
            }
            if(arr[mid] < key){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return res;
    }
}
