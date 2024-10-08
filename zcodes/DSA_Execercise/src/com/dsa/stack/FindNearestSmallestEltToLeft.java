package com.dsa.stack;

import java.util.*;

public class FindNearestSmallestEltToLeft {
    /**
     * Given an array of integers, find the closest (not considering distance, but value) the smallest on left of every element.
     * If an element has no smaller on the left side, print -1 .
     */
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,4};
        System.out.println(Arrays.toString(findNextSmallestELtToLeft(arr)));
    }
    static int[] findNextSmallestELtToLeft(int[] arr){
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()){
                output.add(-1);
            }else if(deque.peek() < arr[i]){
                output.add(deque.peek());
            }else{
                while (deque.size() > 0 && deque.peek() >= arr[i]){
                    deque.poll();
                }
                if(deque.size() > 0){
                    output.add(deque.peek());
                }else{
                    output.add(-1);
                }
            }
            deque.offerFirst(arr[i]);
        }
        return output.stream().mapToInt(x->x).toArray();
    }
}
