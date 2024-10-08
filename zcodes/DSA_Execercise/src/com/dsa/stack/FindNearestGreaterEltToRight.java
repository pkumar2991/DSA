package com.dsa.stack;

import java.util.*;

public class FindNearestGreaterEltToRight {

    /***
     * Given an array, print the Next Greater Element (NGE) for every element.
     * The Next greater Element for an element x is the first greater element on the right side of x in array.
     * Elements for which no greater element exist, consider next greater element as -1.
     * arr = [1,2,3,4]
     */

    public static void main(String[] args) {
        int[] arr = {2,2,7,3,9};
        System.out.println(Arrays.toString(findElt(arr)));
    }
    static int[] findElt(int[] arr){
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0 ; i--) {
            if(deque.isEmpty()){
                result.add(-1);
            }else if(deque.peek() > arr[i]){
                result.add(deque.peek());
            }else {
                while (deque.size() > 0 && deque.peek() <= arr[i]){
                    deque.poll();
                }
                if(deque.size() > 0){
                    result.add(deque.peek());
                }else {
                    result.add(-1);
                }
            }

            deque.offerFirst(arr[i]);
        }
        Collections.reverse(result);
        return result.stream().mapToInt(x->x).toArray();
    }
}
