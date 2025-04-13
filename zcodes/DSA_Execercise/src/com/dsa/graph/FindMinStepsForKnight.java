package com.dsa.graph;

import java.util.*;

public class FindMinStepsForKnight {

    public static void main(String[] args) {
        Pair source = new Pair(3, 4);
        Pair target = new Pair(2, 2);
        int size = 8;
        int minSteps = findMinSteps(source, target, size);
        System.out.println(minSteps);
    }

    private static int findMinSteps(Pair source, Pair target, int size) {
        int step = 0;
        if(source.first == target.first && source.second == target.second) {
            return step;
        }
        // Apply BFS
        Queue<Pair> pairQueue = new ArrayDeque<>();
        Set<Pair> isVisited = new HashSet<>();

        // Set positions as 0-index based
        SetAsZeroBasedIndex(source, target);
        pairQueue.offer(source);
        isVisited.add(source);

        while (!pairQueue.isEmpty()) {
            step++;
            int queSize = pairQueue.size();
            while (queSize > 0) {
                Pair p = pairQueue.poll();
                if(p.first == target.first && p.second == target.second) {
                    return step;
                }

                // Build coordinates of 8 moves of knight
                int[] x = {1,2,2,1,-1,-2,-2,-1};
                int[] y = {2,1,-1,-2,-2,-1,1,2};

                for (int i = 0; i < 8; i++) {
                    Pair p1 = new Pair(p.first+x[i],p.second+y[i]);
                    if(p1.first == target.first && p1.second == target.second) {
                        return step;
                    }
                    if(isValid(size, p1, isVisited)){
                        isVisited.add(p1);
                        pairQueue.offer(p1);
                    }
                }
                queSize--;
            }
        }
        return step;
    }

    private static boolean isValid(int size, Pair p1, Set<Pair> isVisited) {
        return p1.first >= 0 && p1.first < size && p1.second >= 0 && p1.second < size && !isVisited.contains(p1);
    }

    private static void SetAsZeroBasedIndex(Pair source, Pair target) {
        source.first = source.first - 1;
        source.second = source.second - 1;
        target.first = target.first - 1;
        target.second = target.second - 1;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return first == pair.first && second == pair.second;
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}