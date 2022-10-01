package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BinarySearch {

    public int[] twoSum1(int[] numbers, int target) {
        if (numbers.length == 0) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int diff = target - numbers[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i + 1};
            } else {
                map.put(numbers[i], i + 1);
            }
        }
        return new int[]{};
    }

    int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int value = numbers[low] + numbers[high];
            if (value == target) {
                return new int[]{low + 1, high + 1};
            }
            if (value < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{};
    }

    int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] nums : grid) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            count = count + (nums.length - left) - 1;
            if (nums[left] < 0) count++;
        }
        return count;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {0, 10, 15, 5};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.peakIndexInMountainArray(nums));
    }
}
