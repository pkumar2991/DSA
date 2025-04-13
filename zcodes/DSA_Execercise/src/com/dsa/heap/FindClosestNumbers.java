package com.dsa.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class FindClosestNumbers {

    /**
     * Find the closest number of the given key.
     * 5,6,7,8,9 - key 7
     * Given an unsorted array and two numbers x and k, find k closest values to x.
     * Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3 .
     */

    public static void main(String[] args) {
        int[] arr = {10, 2, 14, 4, 7, 6};
        int x = 5;
        int k = 3;
        List<Pair> list = findElts(arr,k,x);
        String collect = list.stream().map(Pair::num).map(String::valueOf).collect(Collectors.joining(","));
        System.out.println(collect);
    }

    static List<Pair> findElts(int[] arr, int k, int x){
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(Pair::diff).reversed());
        List<Pair> pairs = new ArrayList<>();
        for(int num : arr){
            pq.offer(new Pair(num,Math.abs(x-num)));
            if(pq.size() > k){
                pq.poll();
            }
        }
        while (!pq.isEmpty()){
            pairs.add(pq.poll());
        }
        return pairs;
    }

    private record Pair(int num, int diff) {

        @Override
            public String toString() {
                return "Pair{" +
                        "num=" + num +
                        ", diff=" + diff +
                        '}';
            }
        }
}
