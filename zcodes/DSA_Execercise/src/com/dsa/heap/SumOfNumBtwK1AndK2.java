package com.dsa.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfNumBtwK1AndK2 {
    /**
     * Given an array of integers and two numbers k1 and k2.
     * Find the sum of all elements between given two k1’th and k2’th the smallest elements of the array.
     * It may  be assumed that all elements of array are distinct.
     *
     * Example :
     * Input : arr[] = {20, 8, 22, 4, 12, 10, 14},  k1 = 3,  k2 = 6
     * Output : 26
     *          3rd smallest element is 10. 6th smallest element
     *          is 20. Sum of all element between k1 & k2 is
     *          12 + 14 = 26
     */

    public static void main(String[] args) {
        int[] arr = {20, 8, 22, 4, 12, 10, 14};
        int k1 = 3;
        int k2 = 6;
        int first = findKSmallest(arr,k1);
        int second = findKSmallest(arr,k2);
        int sum = Arrays.stream(arr).filter(num -> num > first && num < second).sum();
        System.out.println(sum);
    }

    static int findKSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        for(int num : arr){
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        if(pq.size() > 0)
            return pq.poll();
        return -1;
    }
}
