package com.dsa.graph;

import java.util.*;

public class FindNodesAtSameDistance {
    Graph graph;
    public static void main(String[] args) {
        // Print nodes at each level
        int source = 1;
        FindNodesAtSameDistance findNodesAtSameDistance = new FindNodesAtSameDistance();
        findNodesAtSameDistance.graph = findNodesAtSameDistance.buildGraph();
        findNodesAtSameDistance.levelOrderTraversal(source);
    }
    void levelOrderTraversal(int source){
        Set<Integer> visitedSet = new HashSet<>();
        Map<Integer, List<Integer>> adjList = graph.getAdjList();
        if(!adjList.isEmpty()){
            Queue<Integer> queue = new ArrayDeque<>();
            queue.offer(source);
            int level = 0;
            while (!queue.isEmpty()){
                int size = queue.size();
                System.out.println("Level ="+level);
                while (size > 0){
                    int node = queue.poll();
                    System.out.print(node+" ");
                    for (int num : adjList.get(node)){
                        if(!visitedSet.contains(num)){
                            visitedSet.add(num);
                            queue.offer(num);
                        }
                    }
                    size--;
                }
                level++;
                System.out.println();
            }
        }

    }
    private Graph buildGraph() {
        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(9);

        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
        graph.addEdge(4,5);
        graph.addEdge(3,9);

        return graph;
    }
}
