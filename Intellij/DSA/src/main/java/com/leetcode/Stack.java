package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Stack {
    static class StackNode {
        private int data;
        private int index;

        public StackNode(int data, int index) {
            this.data = data;
            this.index = index;
        }

    }

    int[] stockSpan(int[] arr) {
        // Find Next Greater to left
        Deque<StackNode> stack = new ArrayDeque<>();
        List<StackNode> list = new ArrayList<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                list.add(new StackNode(-1, -1));
            } else if (stack.size() > 0 && stack.peek().data > arr[i]) {
                list.add(new StackNode(stack.peek().data, stack.peek().index));
            } else if (stack.size() > 0 && stack.peek().data <= arr[i]) {
                while (stack.size() > 0 && stack.peek().data <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(new StackNode(-1, -1));
                } else {
                    list.add(new StackNode(stack.peek().data, stack.peek().index));
                }
            }
            stack.push(new StackNode(arr[i], i));
        }
        for (int i = 0; i < arr.length; i++) {
            output[i] = i - list.get(i).index;
        }
        return output;
    }

    int[] nextSmallerElementRight(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                list.add(stack.peek());
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(x -> x).toArray();
    }

    int[] nextSmallerElementLeft(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
            } else if (stack.size() > 0 && stack.peek() < arr[i]) {
                output[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() >= arr[i]) {
                while (stack.size() > 0 && stack.peek() >= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return output;
    }

    int[] nextGreaterElementLeft(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                output[i] = -1;
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                output[i] = stack.peek();
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() > 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    output[i] = -1;
                } else {
                    output[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return output;
    }

    int[] nextGreaterElementRight(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                output.add(-1);
            } else if (stack.size() > 0 && stack.peek() > arr[i]) {
                output.add(stack.peek());
            } else if (stack.size() > 0 && stack.peek() <= arr[i]) {
                while (stack.size() != 0 && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if (stack.size() == 0) {
                    output.add(-1);
                } else {
                    output.add(stack.peek());
                }
            }
            stack.push(arr[i]);
        }
        Collections.reverse(output);
        return output.stream().mapToInt(x -> x).toArray();
    }

    int[] nextGreaterElementRight1(int[] arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] output = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!deque.isEmpty() && arr[i] > arr[deque.peek()]) {
                output[deque.pop()] = arr[i];
            }
            if (deque.isEmpty()) {
                deque.push(i);
            } else if (arr[i] <= arr[deque.peek()]) {
                deque.push(i);
            }
        }
        while (!deque.isEmpty()) {
            output[deque.pop()] = -1;
        }
        return output;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] nextGreaterRightElt = nextGreaterElementRight(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], nextGreaterRightElt[i]);
        }
        int[] output = new int[nums1.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = map.get(nums1[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(Arrays.toString(stack.nextGreaterElementLeft(new int[]{100, 80, 60, 70, 60, 75, 85})));
        System.out.println(Arrays.toString(stack.stockSpan(new int[]{100, 80, 60, 70, 60, 75, 85})));
    }
}
