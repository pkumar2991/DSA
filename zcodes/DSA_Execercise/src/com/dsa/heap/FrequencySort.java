package com.dsa.heap;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FrequencySort {
    /**
     * Sort the given frequencies in descending order.
     * 1,1,1,3,2,2,2,2,4
     * Output: 2,2,2,2,1,1,1,1,3,4
     */
    List<Integer> result = new ArrayList<>();
    Consumer<Frequency> consumer = (frequency -> {
        int num = frequency.getNum();
        long count = frequency.getCount();

        IntStream.rangeClosed(1,(int)count).forEach(x->{
            result.add(num);
        });
    });
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,2,2,2,2,9,9,9};
        FrequencySort frequencySort = new FrequencySort();
        frequencySort.sort(arr);
        System.out.println(frequencySort.result);
    }
    void sort(int[] arr){
        findElts(arr).forEach(consumer);
    }
    List<Frequency> findElts(int[] arr) {
        List<Frequency> heapFrequencies = new ArrayList<>();
        List<Frequency> frequencies = getFrequency(arr).entrySet()
                .stream().map(entry -> new Frequency(entry.getKey(), entry.getValue())).toList();
        if (frequencies.isEmpty()) {
            throw new RuntimeException("Data stream is empty.");
        }
        PriorityQueue<Frequency> pq = new PriorityQueue<>(Comparator.comparingLong(Frequency::getCount).reversed());
        for (Frequency f : frequencies) {
            pq.offer(f);
        }
        while (!pq.isEmpty()) {
            heapFrequencies.add(pq.poll());
        }
        return heapFrequencies;
    }

    Map<Integer,Long> getFrequency(int[] arr){
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
