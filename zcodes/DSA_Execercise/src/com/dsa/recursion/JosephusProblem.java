package com.dsa.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class JosephusProblem {
    /**
     * There are n people standing in a circle (numbered clockwise 1 to n) waiting to be executed.
     * The counting begins at point 1 in the circle and proceeds around the circle in a fixed direction (clockwise).
     * In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds
     * around the circle (which is becoming smaller and smaller as the executed people are removed), until only the
     * last person remains, who is given freedom.
     * Given the total number of persons n and a number k which indicates that k-1 persons are skipped and kth person
     * is killed in circle. The task is to choose the place in the initial circle so that you are the last one
     * remaining
     * and so survive.
     * Consider if n = 5 and k = 2, then the safe position is 3.
     * Firstly, the person at position 2 is killed, then person at position 4 is killed, then person at position 1 is
     * killed. Finally, the person at position 5 is killed. So the person at position 3 survives. .
     */

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        List<Integer> list = new ArrayList<>();
        IntStream.rangeClosed(1,n).forEach(i->list.add(i));
        calculateSafePosition(list,0,k-1);
        System.out.println(list.get(0));
    }

    private static void calculateSafePosition(List<Integer> list, int index,int k) {
        if(list.size() == 1){
            return;
        }
        int indexOfPersonToKill = (index+k) % list.size();
        list.remove(indexOfPersonToKill);
        calculateSafePosition(list,indexOfPersonToKill,k);
    }
}
