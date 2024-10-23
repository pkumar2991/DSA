package com.dsa.recursion;

import java.util.*;

public class SortStackUsingRecursion {
    /**
     * Sort an array using recursion
     * arr = 3,2,7,1,4
     * Time Complexity - O(n^2)
     */

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(3);
        deque.addLast(2);
        deque.addLast(7);
        deque.addLast(1);
        deque.addLast(4);
        Deque<Integer> integerDeque = sortArray(deque);
        System.out.println(integerDeque);
    }

    private static Deque<Integer> sortArray(Deque<Integer> deque) {
        if(deque.size() == 1){
            return deque;
        }
        int temp = deque.poll();
        sortArray(deque);
        insertEltAtRightPosition(deque,temp);
        return deque;
    }

    private static void insertEltAtRightPosition(Deque<Integer> deque, int temp) {
        if(deque.isEmpty() || deque.peekFirst() < temp){
            deque.offerFirst(temp);
            return;
        }
        int ltemp = deque.poll();
        insertEltAtRightPosition(deque,temp);
        deque.offerFirst(ltemp);
    }


}
