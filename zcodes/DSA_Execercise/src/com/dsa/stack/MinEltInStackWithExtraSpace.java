package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinEltInStackWithExtraSpace {
    /**
     * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
     * isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
     * All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard
     * Stack data structure and no other data structure like arrays, list, .. etc.
     */

    public static void main(String[] args) {
        MinEltInStackWithExtraSpace minEltInStackWithExtraSpace = new MinEltInStackWithExtraSpace();
        minEltInStackWithExtraSpace.executeSpecialStack();
    }

    void executeSpecialStack(){
        SpecialStack<Float> stack = new SpecialStack(5);
        stack.push(5.9f);
        stack.push(9.3f);
        stack.push(3.9f);
        stack.push(3.6f);
        stack.push(17.0f);

        stack.pop();
        stack.min();
        if(stack.isEmpty()){
            System.out.println(-1);
        }
        stack.pop();
        stack.pop();
        System.out.println(String.format("%.2f",stack.min().doubleValue()));
        System.out.println(stack.isFull());
    }

    private class SpecialStack<T extends Number>{

        private Deque<T> deque1 = new ArrayDeque<>();
        private Deque<T> deque2 =new ArrayDeque<>();

        private final int size;
        public SpecialStack(int size) {
            this.size = size;
        }
        public void push(T i) {
            deque1.offerFirst(i);
            if(deque2.isEmpty() || i.doubleValue() < deque2.peek().doubleValue()){
                deque2.offerFirst(i);
            }
        }

        public int size(){
            return deque1.size();
        }

        public T pop() {
            if(deque1.isEmpty()){
                throw new RuntimeException(" Special Stack is empty.");
            }
            if(deque2.size() > 0 && deque2.peek().doubleValue() == deque1.peek().doubleValue()){
                deque2.poll();
            }
            return deque1.poll();
        }

        public boolean isEmpty() {
            return deque1.isEmpty();
        }

        public T min() {
            return deque2.peek();
        }

        public boolean isFull(){
            return deque1.size() == 5;
        }
    }

}

