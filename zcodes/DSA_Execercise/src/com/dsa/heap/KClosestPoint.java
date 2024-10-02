package com.dsa.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KClosestPoint {

    /**
     * Given a list of points on the 2-D plane and an integer K. The task is to find K closest points to the origin and print them.
     *
     * Note: The distance between two points on a plane is the Euclidean distance.
     *
     * Example:
     * Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2 .
     */

    public static void main(String[] args) {
        int[][] points = {{3,3},{5,-1},{-2,4},{2,1}};
        int k = 2;
        KClosestPoint kp = new KClosestPoint();
        System.out.println(kp.findPoints(points,k));
    }

    List<Point> findPoints(int[][] points, int k){
        List<Point> closestPoints = new ArrayList<>();
        // max heap
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparingInt(Point::getDist).reversed());
        for (int[] point : points){
            pq.offer(new Point(point[0],point[1]));
            if(pq.size() > k){
                pq.poll();
            }
        }
        while (pq.size() > 0){
            closestPoints.add(pq.poll());
        }
        return closestPoints;
    }

    private class Point{

        private int dist;
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.dist = (int) (Math.pow(this.x,2) + Math.pow(this.y,2));
        }

        public int getDist() {
            return dist;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "dist=" + dist +
                    ", x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}
