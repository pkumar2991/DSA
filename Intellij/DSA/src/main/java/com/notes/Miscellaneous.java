package com.notes;

import java.util.Arrays;

public class Miscellaneous {

    int singleNumber2(int nums[]) {
        int one = 0;
        int two = 0;

        for (int num : nums) {
            one = (one ^ num) & (~two);
            two = (two ^ num) & (~one);
        }
        return one;
    }

    int singleNumber2Alt(int[] nums) {
        int len = nums.length;
        if (len == 0) return -1;
        if (len == 1) return nums[0];
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[len - 1] != nums[len - 2]) {
            return nums[len - 1];
        } else {
            for (int i = 1; i < len; i += 3) {
                if (nums[i] != nums[i - 1]) {
                    return nums[i - 1];
                }
            }
        }
        return -1;
    }

    int sumOfTwoIntegers(int a, int b) {
        while (b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Miscellaneous m = new Miscellaneous();
//        System.out.println(m.sumOfTwoIntegers(-93, 3));
        System.out.println(Integer.toBinaryString(~8));
        System.out.println(Integer.toBinaryString(~8 + 1));
        System.out.println(~8 + 1);
        int bit = 0b11111111111111111111111111111000;
        System.out.println(-(~bit+1));
    }
}
