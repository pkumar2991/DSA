package com.dsa.stack;

import java.util.*;

public class StockSpan {
    /**
     * The stock span problem is a financial problem where we have a series of n daily price quotes for a
     * stock and we need to calculate span of stock’s price for all n days.
     * The span Si of the stock’s price on a given day i is defined as the maximum number
     * of consecutive days just before the given day, for which the price of the stock on the
     * current day is less than or equal to its price on the given day.
     * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
     * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
     */

    public static void main(String[] args) {
        int[] prices = {100,80,60,70,60,75,85};
        int[] ngl = findNgl(prices);
        System.out.println(Arrays.toString(ngl));
        for (int i = 0; i < ngl.length; i++) {
            System.out.print(i - ngl[i]);
        }

    }
    static int[] findNgl(int[] arr){
        Deque<Pair> deque = new ArrayDeque<>();
       List<Pair> output = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(deque.isEmpty()){
                output.add(new Pair(arr[i],-1));
            }else if(deque.peek().num > arr[i]){
                output.add(new Pair(arr[i],deque.peek().index));
            }else{
                while (deque.size() > 0 && deque.peek().num <= arr[i]){
                    deque.poll();
                }
                if(deque.isEmpty()){
                    output.add(new Pair(arr[i],-1));
                }else{
                    output.add(new Pair(arr[i],deque.peek().index));
                }
            }
            deque.offerFirst(new Pair(arr[i],i));
        }
        System.out.println(output);
        return output.stream().mapToInt(Pair::index).toArray();
    }
    private record Pair(int num,int index){}

}
