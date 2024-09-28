package com.dsa.binarysearch;

public class FindEltInBitonicArray {

    /**
     * Find an element in the given bitonic array. If the element exist return the
     * index of the element.
     *
     * Approach - Find the index of the peak element and then run BS on left(asc sorted) and later on right
     * (desc sorted).
     */

    public static void main(String[] args) {
        int[] arr = {1,3,8,12,4,2};
        int key = 2;
        int keyEltIndex = -1;
        int peakIndex = findPeakElt(arr,0,arr.length-1);
        System.out.println(peakIndex);
        if(arr[peakIndex] == key) {
            System.out.println(peakIndex);
        }else{
            keyEltIndex = findKeyElt(arr,peakIndex,key);
            System.out.println(keyEltIndex);
        }

    }

    static int findPeakElt(int[] arr, int start, int end){
        int len = arr.length;
        if(len <= 1) return -1;
        int mid = start + ( end - start) / 2;
        if(mid == 0){
            if(arr[mid] > arr[mid + 1])
                return mid;
            else
                return mid + 1;
        }else if ( mid == len - 1){
            if(arr[mid] > arr[len-1])
                return mid;
            else
                return len - 1;
        }else {
            if(arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]){
                return mid;
            }else if(arr[mid] <= arr[mid + 1]){
                return findPeakElt(arr,mid+1,end);
            }else{
                return findPeakElt(arr,start,mid-1);
            }
        }
    }

    static int findKeyElt(int[] arr,int peakIndex,int key){
        return findKeyEltInSortedAsc(arr,0,peakIndex - 1,key) == -1
                ? findKeyEltInSortedDesc(arr,peakIndex + 1, arr.length - 1,key)
                : findKeyEltInSortedAsc(arr,0,peakIndex - 1,key);
    }

    static int findKeyEltInSortedAsc(int[] arr, int start, int end, int key){
        if(start > end) return -1;
        int mid = start + ( end - start ) / 2;
        if(arr[mid] == key)
            return mid;
        else if(arr[mid] < key){
            return findKeyEltInSortedAsc(arr,mid + 1, end, key);
        }else{
            return findKeyEltInSortedAsc(arr,start, mid - 1, key);
        }
    }

    static int findKeyEltInSortedDesc(int[] arr, int start, int end, int key){
        if(start > end) return -1;
        int mid = start + ( end - start ) / 2;
        if(arr[mid] == key)
            return mid;
        else if(arr[mid] > key){
            return findKeyEltInSortedAsc(arr,mid + 1, end, key);
        }else{
            return findKeyEltInSortedAsc(arr,start, mid - 1, key);
        }
    }

}
