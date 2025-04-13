package com.dsa.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseStack {
    /**
     * Reverse a stack - 10,2,8,9,5 with O(1) space complexity.
     * Time complexity - O(n^2)
     */

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        Deque<Integer> deque = buildDeque(arr);
        System.out.println(deque);
        reverseStack(deque);
        System.out.println(deque);
    }

    private static void reverseStack(Deque<Integer> deque) {
        if(deque.isEmpty()){
            return;
        }
        int temp = deque.poll();
        reverseStack(deque);
        insertNum(deque,temp);
    }

    private static void insertNum(Deque<Integer> deque, int temp) {
        if(deque.isEmpty()){
            deque.offerFirst(temp);
            return;
        }

        int temp1 = deque.poll();
        insertNum(deque,temp);
        deque.offerFirst(temp1);

    }

    private static Deque<Integer> buildDeque(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int num: arr){
            deque.offerFirst(num);
        }
        return deque;
    }
}
