package com.leetcode;

import java.util.PriorityQueue;

public class Heap {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // Creates Max-Heap
        for (int weight : stones) {
            queue.add(weight);
        }
        while (!queue.isEmpty() && queue.size() > 1) {
            int x = queue.poll();
            int y = queue.poll();
            if (x != y) {
                if (x > y) {
                    queue.add(x - y);
                } else {
                    queue.add(y - x);
                }
            }
        }
        if (queue.isEmpty()) return 0;
        else
            return queue.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        for (int num :
                nums) {
            maxHeap.add(num);
        }
        for (int i = 1; i < k; i++) {
            maxHeap.poll();
        }
        return maxHeap.poll();
    }

    public int findKthLargestUsingMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num :
                nums) {
            minHeap.add(num);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.remove();
    }


    public static void main(String[] args) {
        int[] nums = {0,10,50,2};
        int k = 4;
        Heap heap = new Heap();
//        System.out.println(heap.peakIndexInMountainArray(nums));
    }
}
