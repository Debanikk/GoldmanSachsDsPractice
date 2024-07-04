package com.wildfire.LeetCode75.graphPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMinSpanningTree {
    public static void main(String[] args) {
        // Creating a graph that has 6 vertices
        //          4
        //   0--------       -----------3-------
        //   |        \     / 3                 \ 2
        //   |         \   /           6         \
        //   | 4         2 ---------------------- 4
        //   |         /   \                     /
        //   |        /     \ 1                 / 3
        //   1--------       ---------5---------
        //          2

        WeightedGraph graph = new WeightedGraph(6);
        graph.addUndirectedEdge(0,1,4);
        graph.addUndirectedEdge(0,2,4);
        graph.addUndirectedEdge(1,2,2);
        graph.addUndirectedEdge(2,3,3);
        graph.addUndirectedEdge(2,4,6);
        graph.addUndirectedEdge(2,5,1);
        graph.addUndirectedEdge(3,4,2);
        graph.addUndirectedEdge(5,4,3);

        // Code to print the graph
        List<GraphEdge>[] vertices = graph.getVertices();
        for (int i = 0; i < vertices.length; i++) {
            System.out.print("Vertex " + i + " is connected to: ");
            for (GraphEdge edge : vertices[i])
                System.out.print(edge.getDestination() + " ");
            System.out.println();
        }
        System.out.println(" ");
        System.out.println(" ---------- ");
        System.out.println(" ");
        // List of graph edge for min spanning tree -
        List<GraphEdge> spanningTree = primMST(graph);
        for (GraphEdge edge : spanningTree) {
            System.out.println("Edge source is - " + edge.getSource());
            System.out.println("Edge destination is - " + edge.getDestination());
            System.out.println("Edge weight is - " + edge.getWeight());
            System.out.println(" ------ ");
        }
    }

    private static List<GraphEdge> primMST(WeightedGraph graph) {
        List<GraphEdge>[] vertices = graph.getVertices();

        boolean[] inMST = new boolean[vertices.length];
        PriorityQueue<GraphEdge> minHeap = new PriorityQueue<>(Comparator.comparingInt(GraphEdge::getWeight));

        List<GraphEdge> mstEdges = new ArrayList<>();

        // start from vertex 0
        int startVertex = 0;
        inMST[startVertex] = true;

        // add all edges from the start Vertex to the priority queue
        minHeap.addAll(vertices[startVertex]);

        while(!minHeap.isEmpty()) {
            GraphEdge currentEdge = minHeap.poll();

            int destination = currentEdge.getDestination();
            if(inMST[destination])
                continue;
            mstEdges.add(currentEdge);
            inMST[destination] = true;
            minHeap.addAll(vertices[destination]);
        }
        return mstEdges;
    }
}
