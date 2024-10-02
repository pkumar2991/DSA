package com.dsa.heap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
                .stream().map(entry -> new Frequency(entry.getKey(), entry.getValue())).collect(Collectors.toList());
        if (frequencies.size() == 0) {
            throw new RuntimeException("Data stream is empty.");
        }
        PriorityQueue<Frequency> pq = new PriorityQueue<>(Comparator.comparingLong(Frequency::getCount));
        for (Frequency f : frequencies) {
            pq.offer(f);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() > 0) {
            topFreqNumbers.add(pq.poll().getNum());
        }
        return topFreqNumbers;
    }

    static Map<Integer,Long> getFrequency(int[] arr){
        return Arrays.stream(arr).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static class Frequency{
        private final int num;
        private final Long count;

        public Frequency(int num, Long count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public Long getCount() {
            return count;
        }
    }
}
