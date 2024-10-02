package com.dsa.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Find2SmallestElt {

    /**
     * Find the second-largest element in the given array.
     * Time Complexity - n log (K)
     */
    public static void main(String[] args) {
        int[] arr = {12,4,5,88,20};
        System.out.println(findElt(arr,2));
    }
    static int findElt(int[] arr,int k){
        // Max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(Integer::intValue).reversed());
        for (int num : arr) {
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
