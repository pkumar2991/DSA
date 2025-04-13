package com.dsa.graph;

import java.util.*;
import java.util.function.Consumer;

public class Graph {

    private final Map<Integer, List<Integer>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    public void addVertex(int vertex){
        adjList.put(vertex,new ArrayList<>());
    }

    public void addEdge(int source, int dest){
        adjList.get(source).add(dest);
    }

    public void removeVertex(int vertex){
        adjList.remove(vertex);
        for(List<Integer> neighbours : adjList.values()){
            neighbours.remove(Integer.valueOf(vertex));
        }
    }
    private final Consumer<Map.Entry<Integer,List<Integer>>> consumer = (entry)->{
        System.out.printf("%d   %s\n",entry.getKey(), entry.getValue().toString());
    };
    public void printGraph(){
        System.out.println("Vertices    Edges(Neighbours");
        adjList.entrySet().forEach(consumer);
    }

    public Map<Integer, List<Integer>> getAdjList(){
        return adjList;
    }

}