package com.dsa.binarysearch;

public class FindIndexOf1stOcurrOfANum {

    public static void main(String[] args) {
        int arr[] = {1,2,3,10,10,12,12,12,14,16,16};
        int key = 16;
        int res = findElt(arr,key);
        System.out.println(res);
        System.out.println(arr[res]);
        System.out.println(findEltRecursion(arr,0,arr.length-1,key,-1));
    }

    static int findElt(int[] arr,int key){
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

    static int findEltRecursion(int[] arr,int start, int end, int key,int res){
        if(start > end) return res;
        int mid = start + (end - start) / 2;
        if(key <= arr[mid]){
            res = mid;
            return findEltRecursion(arr,start,mid-1,key,res);
        }else{
            return findEltRecursion(arr,mid+1,end,key,res);
        }
    }
}
