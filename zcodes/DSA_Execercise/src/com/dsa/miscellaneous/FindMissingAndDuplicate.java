package com.dsa.miscellaneous;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FindMissingAndDuplicate {
    /**
     * Given an unsorted array of size n. Array elements are in the range from 1 to n.
     * Some numbers from set {1, 2, …n} are missing and some are repeating in the array.
     * Find these two numbers in order of one space.
     *
     *
     * Input:[3 1 1 5 3]
     *
     * Duplicate = 3,1  Missing = 2,4
     * Time Complexity - (n-1)+(n-1) = 2n-1 = O(n)
     *
     * SWAP SORT Concept - Provided the array is a mutable array
     */

    public static void main(String[] args) {
        int[] arr = {3,1,1,5,3};
        List<Integer> duplicateNums = new ArrayList<>();
        List<Integer> missingNums = new ArrayList<>();
        findElts(arr,duplicateNums,missingNums);
        System.out.println("Missing Numbers : " +missingNums.stream().map(String::valueOf).collect(Collectors.joining(",")));
        System.out.println("Duplicate Numbers :" + duplicateNums.stream().map(String::valueOf).collect(Collectors.joining(",")));
    }

    private static void findElts(int[] arr, List<Integer> duplicateNums, List<Integer> missingNums) {
        int i = 0;
        while (i < arr.length){
            if(arr[i] != i+1){
                swapElts(arr,i,arr[i]-1);
            }
            i++;
        }

        for (int j = 0; j < arr.length; j++) {
            if(arr[j] - 1 != j){
                duplicateNums.add(arr[j]);
                missingNums.add(j+1);
            }
        }

    }

    private static void swapElts(int[] arr,int source,int target){
        int temp = arr[target];
        arr[target] = arr[source];
        arr[source] = temp;
    }
}
