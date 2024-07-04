package com.wildfire.LeetCode75.graphPractice;

import java.util.*;


/// This is representation of Undirected graph
public class AdjacencyListGraph {
    private Map<Integer, List<Integer>> adjacencyList;
    public AdjacencyListGraph() {
        this.adjacencyList = new HashMap<>();
    }

    /// Add vertex to graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new LinkedList<>());
    }

    /// Add vertices between two edges
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /// remove edges from two vertices
    public void removeEdge(int source, int destination) {
        adjacencyList.get(source).remove((Integer) destination);
        adjacencyList.get(destination).remove((Integer) source);
    }

    /// remove a existing vertex from graph
    /// for this remove the vertex and also remove the vertex value
    /// that is present for any of the other vertices edge
    public void removeVertex(int vertex) {
        adjacencyList.remove(vertex);
        for(List<Integer> neighbours : adjacencyList.values()) {
            neighbours.remove((Integer) vertex);
        }
    }

    /// Iterative approach for depth first search
    public Set<Integer> DFSIterative(int startVertex) {
        // store the visited vertex
        Set<Integer> visited = new HashSet<>();
        // storage for the neighboring edges of the visited nodes
        Stack<Integer> stack = new Stack<>();

        // push the start vertex in the stack
        stack.push(startVertex);

        // loop till the end of the stack until it is completely empty
        while(!stack.isEmpty()) {
            // take out the first vale from stack as a LIFO system
            int currentVertex = stack.pop();
            System.out.println(currentVertex + " ");
            // add this node in the visited set
            visited.add(currentVertex);

            // loop through the adjacencyList of the graph and
            // check each vertex value popped out of stack if
            // it is present in visited set or not. If absent
            // then add the vertex in the visited set
            for(int neighbour : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                if(!visited.contains(neighbour)) {
                    stack.push(neighbour);
                }
            }
        }

        return visited;
    }

    /// Depth first search in recursive way
    public Set<Integer> DFS(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        DFSRecursive(startVertex, visited);
        return visited;
    }

    // recursion method for DF search
    private void DFSRecursive(int vertex, Set<Integer> visited) {
        visited.add(vertex);

        System.out.println(vertex + " ");
        for(int neighbour : adjacencyList.getOrDefault(vertex, Collections.emptyList())) {
            if(!visited.contains(neighbour)) {
                DFSRecursive(neighbour, visited);
            }
        }
    }

    /// Breadth first search for a graph in Iterative way
    public void BFSIterative(int startVertex) {
        // visited set for storing vertex that has been traversed
        Set<Integer> visited = new HashSet<>();
        // q queue for capturing neighbours in level basis
        Queue<Integer> queue = new LinkedList<>();

        //add startVertex to both queue and visited set
        queue.add(startVertex);
        visited.add(startVertex);

        // iterate through the queue to reach levels of the graph and
        // mark it visited until the queue is empty which denotes that
        // all vertices in the graph are visited
        while(!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.println(currentVertex + " ");
            for(int neighbour : adjacencyList.getOrDefault(currentVertex, Collections.emptyList())) {
                if(!visited.contains(neighbour)) {
                    queue.add(neighbour);
                    visited.add(neighbour);
                }
            }
        }
    }
}
