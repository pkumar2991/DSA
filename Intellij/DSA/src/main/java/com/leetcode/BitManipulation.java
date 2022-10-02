package com.leetcode;

import java.util.Arrays;

public class BitManipulation {

    public int[] singleNumberIII(int[] nums) {
        int xor = 0;
        int x = 0;
        int y = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int rmsb = xor & (-xor);
        for (int num : nums) {
            if ((num & rmsb) == 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }
    public boolean isPowerOfFour(int n) {
        int temp = Integer.parseInt("1010101010101010101010101010101",2);
        return (n > 0 && (n & (n-1)) == 0 && (n & temp) != 0);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 3, 5, 2, 9};
        BitManipulation bitManipulation = new BitManipulation();
        int[] output = bitManipulation.singleNumberIII(nums);
        System.out.println(bitManipulation.isPowerOfFour(8));
    }
}
