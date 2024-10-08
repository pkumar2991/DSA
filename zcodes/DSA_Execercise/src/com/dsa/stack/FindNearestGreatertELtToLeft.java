package com.dsa.stack;

import java.util.*;

public class FindNearestGreatertELtToLeft {

    /**
     * Given an array of integers, find the closest (not considering distance, but value) greater on left of every element.
     * If an element has no greater on the left side, print -1 .
     */

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,1};
        System.out.println(Arrays.toString(findNearestGrtEltToLeft(arr)));
    }

    public static int[] findNearestGrtEltToLeft(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()){
                output.add(-1);
            }else if(deque.peek() > arr[i]){
                output.add(deque.peek());
            }else{
                while (deque.size() > 0 && deque.peek() < arr[i]){
                    deque.poll();
                }
                if(deque.isEmpty()){
                    output.add(-1);
                }else{
                    output.add(deque.peek());
                }
            }
            deque.offerFirst(arr[i]);
        }
        return output.stream().mapToInt(x->x).toArray();
    }
}
