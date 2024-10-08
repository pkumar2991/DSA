package com.dsa.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class FindMaxRainWaterTrapping {
    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * compute how much water it is able to trap after raining.
     * Input: arr[]   = {2, 0, 2}
     * Output: 2
     *
     * Maximum water trapped =
     * Min(Max height left of the building,Max height right of the building) - height of the building
     *
     */

    public static void main(String[] args) {
        int[] heights = {3,0,0,2,0,4};
        FindMaxRainWaterTrapping findMaxRainWaterTrapping = new FindMaxRainWaterTrapping();
        int maxArea = findMaxRainWaterTrapping.findMaxArea(heights);
        System.out.println(maxArea);
    }

    private int findMaxArea(int[] heights) {
        int[] maxHeightsLeft = findMaxHeightLeft(heights);
        int[] maxHeightsRight = findMaxHeightRight(heights);
        List<Integer> areaList = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            int waterOnEachBuilding = Math.min(maxHeightsLeft[i],maxHeightsRight[i]) - heights[i];
            areaList.add(waterOnEachBuilding);
        }
        return areaList.stream().mapToInt(x->x).sum();
    }

    private int[] findMaxHeightRight(int[] heights) {
        int max = -1;
        int[] maxHeightArrRight = new int[heights.length];
        for (int i = heights.length - 1; i >= 0; i--) {
            if(heights[i] > max){
                maxHeightArrRight[i] = heights[i];
                max = heights[i];
            }else{
                maxHeightArrRight[i] = max;
            }
        }
        return maxHeightArrRight;
    }

    private int[] findMaxHeightLeft(int[] heights) {
        int max = -1;
        int[] maxHeightArrLeft = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] > max){
                maxHeightArrLeft[i] = heights[i];
                max = heights[i];
            }else{
                maxHeightArrLeft[i] = max;
            }
        }
        return maxHeightArrLeft;
    }

}
