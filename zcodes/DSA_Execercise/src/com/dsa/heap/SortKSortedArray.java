package com.dsa.heap;

import java.util.*;
import java.util.stream.IntStream;

public class SortKSortedArray {

    /**
     * Sort K sorted array / Sort nearly sorted array
     * Definition - In the given array, for any index the sorted element exist within the kth index from the element.
     * 6,5,3,2,8,10,9  and K = 3
     * At 1st position, value should be 2 which exist within  next 3rd elements.
     *
     * At a time we need to sort only k elements and in which we need to find the min value. This question gets
     * converted into heap question.
     *
     * Time complexity = n log(k)
     */

    public static void main(String[] args) {
        int[] arr = {6,5,3,2,8,10,9};
        System.out.println(Arrays.toString(sortArray(arr,3)));
    }

    static int[] sortArray(int[] arr,int k){
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
        {
            pq.offer(arr[i]);
            if(pq.size() > k){
                list.add(pq.poll());
            }
        }
        while (!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
