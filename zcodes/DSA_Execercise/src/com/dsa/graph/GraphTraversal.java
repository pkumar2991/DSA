package com.dsa.graph;

import java.util.*;

public class GraphTraversal {
// Time complexity - O(V+E)
    static Map<Integer, List<Integer>> adjList = null;
    static int[] visitedArr;
    static List<Integer> dfsTraverseList = new ArrayList<>();
    public static void main(String[] args) {
       Graph graph = buildGraph();
       graph.printGraph();
        adjList = graph.getAdjList();
        visitedArr = new int[adjList.size()+1];
        boolean hasValidPath = validPath(5,adjList,4,7);

       //depthFirstTraversal(adjList,visitedArr,1,dfsTraverseList);
        System.out.printf("Has valid path between %d & %d: %b",0,3,hasValidPath);
      // breadthFirstTraversal(graph,1);
    }

    private static boolean validPath(int n, Map<Integer, List<Integer>> adjList, int source,int destination){
        depthFirstTraversal(adjList,visitedArr,source,dfsTraverseList);
        if(destination >= visitedArr.length)
            return false;
        return visitedArr[destination] == 1;
    }

    private static void depthFirstTraversal(Map<Integer, List<Integer>> adjList, int[] visitedNodes, int source,List<Integer> dfsTraverseList) {
        List<Integer> neighbours = adjList.get(source);
        visitedNodes[source] = 1;
        dfsTraverseList.add(source);
        for (int neighbour : neighbours){
            if(visitedNodes[neighbour] == 0){
                depthFirstTraversal(adjList,visitedNodes,neighbour,dfsTraverseList);
            }
        }
    }

    private static void breadthFirstTraversal(Graph graph, int source) {
        Map<Integer, List<Integer>> adjList = graph.getAdjList();
        int[] visitedArr = new int[adjList.size()+1];
        Queue<Integer> pq = new ArrayDeque<>();
        pq.offer(source);
        visitedArr[source] = 1;

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()){
            int node = pq.poll();
            List<Integer> neighbours = adjList.get(node);
            sb.append(node).append(" ");
            for (int neighbour : neighbours){
                if(visitedArr[neighbour] == 0){
                    visitedArr[neighbour] = 1;
                    pq.offer(neighbour);
                }
            }
        }
        System.out.println(sb);
    }

    private static Graph buildGraph() {
        Graph graph = new Graph();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(9);

        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(1,2);
        graph.addEdge(2,1);
        graph.addEdge(1,4);
        graph.addEdge(4,1);
        graph.addEdge(2,3);
        graph.addEdge(3,2);
        graph.addEdge(5,9);
        graph.addEdge(9,5);

        return graph;
    }
}
