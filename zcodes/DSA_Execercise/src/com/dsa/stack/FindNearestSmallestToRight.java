package com.dsa.stack;


import java.util.*;

public class FindNearestSmallestToRight {
    /**
     * Given an array of integers, find the closest (not considering distance, but value) smaller on rightof every element.
     * If an element has no smaller on the right side, print -1
     */

    public static void main(String[] args) {
        int[] arr = {1,3,2,5,4};
        System.out.println(Arrays.toString(findNearestSmallerEltToRight(arr)));

    }

    private static int[] findNearestSmallerEltToRight(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for(int i = arr.length - 1; i >= 0; i--){
            if(deque.isEmpty()){
                output.add(-1);
            }else if(deque.peek() < arr[i]){
                output.add(deque.peek());
            }else {
                while (deque.size() > 0 && deque.peek() >= arr[i]){
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
        Collections.reverse(output);
        return output.stream().mapToInt(x->x).toArray();
    }


}
