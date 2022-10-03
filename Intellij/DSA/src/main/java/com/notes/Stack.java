package com.notes;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Stack {
    boolean isBalancedBracket(String brackets) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char symbol : brackets.toCharArray()) {
            if (!stack.isEmpty()) {
                char topChar = stack.peek();
                if (topChar == '(' && symbol == ')') stack.pop();
                else if (topChar == '{' && symbol == '}') stack.pop();
                else if (topChar == '[' && symbol == ']') stack.pop();
                else {
                    stack.push(symbol);
                }
            } else {
                stack.push(symbol);
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    int[] nextGreaterElementRight(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.peek()]){
                output[deque.pop()] = arr[i];
            }
            if(deque.isEmpty()){
                deque.push(i);
            }else if (arr[i] <= arr[deque.peek()]) {
                deque.push(i);
            }
        }
        while (!deque.isEmpty()){
            output[deque.pop()] = -1;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] arr = {13,7,6,12,10};
        Stack stack = new Stack();
        System.out.println(Arrays.toString(stack.nextGreaterElementRight(arr)));
    }
}
