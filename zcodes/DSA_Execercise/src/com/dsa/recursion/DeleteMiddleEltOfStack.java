package com.dsa.recursion;

import java.util.ArrayDeque;
import java.util.Deque;

public class DeleteMiddleEltOfStack {
    /**
     * Given stack - {1,8,3,5,9}
     * Delete the middle element of the stack.
     * Middle element
     * if odd - size/2
     * if even - size/2 + 1
     */

    public static void main(String[] args) {
        int[] arr = {1,8,3,5,9,11,12,14};
        Deque<Integer> deque = buildDeque(arr);
        System.out.println(deque);
        deleteMiddleElt(deque,findMiddleElt(deque));
        System.out.println(deque);

    }

    private static void deleteMiddleElt(Deque<Integer> deque,int k) {
        if(k == 1){
            deque.poll();
            return;
        }
        int temp = deque.poll();
        deleteMiddleElt(deque,k-1);
        deque.offerFirst(temp);
    }

    private static int findMiddleElt(Deque<Integer> deque){
        return (deque.size() / 2) + 1;
    }

    private static Deque<Integer> buildDeque(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for(int num: arr){
            deque.offerFirst(num);
        }
        return deque;
    }
}
