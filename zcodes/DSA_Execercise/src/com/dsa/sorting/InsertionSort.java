package com.dsa.sorting;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {7,4,3,5,9};
        System.out.println(Arrays.toString(arr));
        sortArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortArray(int[] arr) {
        int hole = -1;
        int temp = -1;
        for (int i = 1; i < arr.length; i++) {
            hole = i;
            temp = arr[hole];
            while (hole > 0 && arr[hole - 1] > temp){
                arr[hole] = arr[hole - 1];
                hole--;
            }
            arr[hole] = temp;
        }
    }
}
