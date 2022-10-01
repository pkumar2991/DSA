package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Array {

    int[] sortArrayByParity1(int[] arr) {
        Comparator<Integer> comparator = Comparator.comparingInt(a -> a % 2);
        List<Integer> list = new ArrayList<>();
        for (int num :
                arr) {
            list.add(num);
        }
        Collections.sort(list, comparator);
        return list.stream().mapToInt(x -> x).toArray();
    }
    int[] sortArrayByParity(int[] nums) {
        Comparator<Integer> comparator = Comparator.comparingInt(a -> a % 2);
        List<Integer> list = new ArrayList<>();
        for (int num :
                nums) {
            list.add(num);
        }
        Collections.sort(list, comparator);
        for (int i = 0; i < nums.length; i++) {
            nums[i]=list.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Array arr = new Array();
        int[] nums = new int[]{1, 3, 2, 5};
        nums = arr.sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }
}
