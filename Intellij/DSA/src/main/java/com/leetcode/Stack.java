package com.leetcode;

import java.util.*;

public class Stack {

    int[] nextGreaterElementRight(int[] arr) {
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
        Map<Integer,Integer> map = new HashMap<>();
        int[] nextGreaterRightElt = nextGreaterElementRight(nums2);
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i],nextGreaterRightElt[i]);
        }
        int[] output = new int[nums1.length];
        for (int i = 0; i < output.length; i++) {
            output[i] = map.get(nums1[i]);
        }
        return output;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        System.out.println(Arrays.toString(stack.nextGreaterElement(new int[]{2,4},new int[]{1,2,3,4})));
    }
}
