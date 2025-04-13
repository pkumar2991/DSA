package com.dsa.heap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class TopKFrequentNumbers {

    /**
     * Find the Top k frequency of the given numbers
     * 1 1 1 3 2 4
     */
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,2,2,4};
        int k = 2;
        System.out.println(findElts(arr,k));
    }

    static List<Integer> findElts(int[] arr,int k) {
        List<Integer> topFreqNumbers = new ArrayList<>();
        List<Frequency> frequencies = getFrequency(arr).entrySet()
                .stream().map(entry -> new Frequency(entry.getKey(), entry.getValue())).toList();
        if (frequencies.isEmpty()) {
            throw new RuntimeException("Data stream is empty.");
        }
        PriorityQueue<Frequency> pq = new PriorityQueue<>(Comparator.comparingLong(Frequency::count));
        for (Frequency f : frequencies) {
            pq.offer(f);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            topFreqNumbers.add(pq.poll().num());
        }
        return topFreqNumbers;
    }

    static Map<Integer,Long> getFrequency(int[] arr){
        return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private record Frequency(int num, Long count) {
    }
}
