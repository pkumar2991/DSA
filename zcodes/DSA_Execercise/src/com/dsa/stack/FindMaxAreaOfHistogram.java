package com.dsa.stack;

import java.util.*;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class FindMaxAreaOfHistogram {
    /**
     * Find the largest rectangular area possible in a given histogram where the largest
     * rectangle can be made of a number of contiguous bars.
     * For simplicity, assume that all bars have same width and the width is 1 unit.
     */
    private record Building(int height, int width) {
    }

    private record Pair(int num, int index) {
    }

    public static void main(String[] args) {
        int[] height = {6, 2, 5, 4, 5, 2, 2, 1, 6};
        int currentWidth = 1;
        FindMaxAreaOfHistogram findMaxAreaOfHistogram = new FindMaxAreaOfHistogram();
        int maxArea = findMaxAreaOfHistogram.findMaxArea(height);
        System.out.println(maxArea);
    }

    int findMaxArea(int[] height) {
        int maxArea = -1;
        List<Building> buildingList = getBuildingList(height, findNearestSmallerEltRightIndices(height), findNearestSmallerEltLeftIndices(height));
        OptionalInt max = buildingList.stream().mapToInt(building -> building.height * building.width).max();
        if (max.isPresent()) {
            maxArea = max.getAsInt();
        }
        return maxArea;
    }

    private List<Building> getBuildingList(int[] height, int[] nearestSmallerEltToRightIndices, int[] nearestSmallerEltToLeftIndices) {
        IntUnaryOperator widthOperator = i -> nearestSmallerEltToRightIndices[i] - nearestSmallerEltToLeftIndices[i] - 1;
        int[] widthArr = IntStream.range(0, height.length).map(widthOperator).toArray();
        List<Building> buildingList = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            buildingList.add(new Building(height[i], widthArr[i]));
        }
        return buildingList;
    }


    private int[] findNearestSmallerEltLeftIndices(int[] height) {
        Deque<Pair> deque = new ArrayDeque<>();
        List<Pair> nearestSmallerLeftEltIndices = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (deque.isEmpty()) {
                nearestSmallerLeftEltIndices.add(new Pair(height[i],-1));
            } else if (deque.peek().num < height[i]) {
                nearestSmallerLeftEltIndices.add(new Pair(height[i],deque.peek().index));
            } else {
                while (deque.size() > 0 && deque.peek().num >= height[i]) {
                    deque.poll();
                }
                if (deque.isEmpty()) {
                    nearestSmallerLeftEltIndices.add(new Pair(height[i],-1));
                } else {
                    nearestSmallerLeftEltIndices.add(new Pair(height[i],deque.peek().index));
                }
            }
            deque.offerFirst(new Pair(height[i],i));
        }
        return nearestSmallerLeftEltIndices.stream().mapToInt(x -> x.index).toArray();
    }

    private int[] findNearestSmallerEltRightIndices(int[] height) {
        Deque<Pair> deque = new ArrayDeque<>();
        List<Pair> nearestSmallerRightEltIndices = new ArrayList<>();
        for (int i = height.length-1; i >= 0; i--) {
            if(deque.isEmpty()){
                nearestSmallerRightEltIndices.add(new Pair(height[i],height.length));
            }else if(deque.peek().num < height[i]){
                nearestSmallerRightEltIndices.add(new Pair(height[i],deque.peek().index));
            }else{
                while (deque.size() > 0 && deque.peek().num >= height[i]){
                    deque.poll();
                }
                if(deque.isEmpty()){
                    nearestSmallerRightEltIndices.add(new Pair(height[i],height.length));
                }else{
                    nearestSmallerRightEltIndices.add(new Pair(height[i],deque.peek().index));
                }
            }
            deque.offerFirst(new Pair(height[i],i));
        }
        Collections.reverse(nearestSmallerRightEltIndices);
        return nearestSmallerRightEltIndices.stream().mapToInt(x->x.index).toArray();
    }


}
