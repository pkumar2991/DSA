package com.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinEltInStackWithNoExtraSpace {
    /**
     * Design a Data Structure SpecialStack that supports all the stack operations like push(), pop(), isEmpty(),
     * isFull() and an additional operation getMin() which should return minimum element from the SpecialStack.
     * All these operations of SpecialStack must be O(1). To implement SpecialStack, you should only use standard
     * Stack data structure and no other data structure like arrays, list, .. etc.
     * Provided numbers are non-negative.
     * Space Complexity - O(1)
     *
     * Note-This need to be tested for negative numbers
     */

    public static void main(String[] args) {
        MinEltInStackWithNoExtraSpace m = new MinEltInStackWithNoExtraSpace();
        m.executeSpecialStack();
    }

    void executeSpecialStack(){
        SpecialStack<Integer> stack = new SpecialStack(5);
        stack.push(18);
        stack.push(19);
        stack.push(17);
        stack.push(15);
        stack.push(21);

        stack.pop();
        System.out.println(stack.min());
        if(stack.isEmpty()){
            System.out.println(-1);
        }
        stack.pop();
        stack.pop();
        System.out.println(stack.min());
        System.out.println(stack.isFull());
    }

    private class SpecialStack<T extends Number>{

        private Deque<Number> deque1 = new ArrayDeque<>();
        double min = -1;
        private final int size;
        public SpecialStack(int size) {
            this.size = size;
        }
        public void push(Number i) {
            if(deque1.isEmpty()){
                min = i.doubleValue();
                deque1.offerFirst(i);
            }else if (i.doubleValue() > min){
                deque1.offerFirst(i);
            }else{
                // value to be inserted in stack = 2 * num - currentMin
                double value = (2 * i.doubleValue()) - min;
                min = i.doubleValue();
                deque1.offerFirst(value); // error fix this
            }

        }

        public int size(){
            return deque1.size();
        }

        public Number pop() {
            if(deque1.isEmpty()){
                throw new RuntimeException(" Special Stack is empty.");
            }
            if(deque1.peek().doubleValue() < min){
                // Restore the previous
                min = 2 * min - deque1.peek().doubleValue();
                return deque1.poll();
            }else{
                return deque1.poll();
            }
        }

        public boolean isEmpty() {
            return deque1.isEmpty();
        }

        public Number min() {
            return min;
        }

        public boolean isFull(){
            return deque1.size() == 5;
        }
    }

}

