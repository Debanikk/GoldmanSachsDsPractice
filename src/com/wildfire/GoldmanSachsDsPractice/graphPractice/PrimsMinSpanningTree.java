package com.wildfire.GoldmanSachsDsPractice.graphPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMinSpanningTree {
    public static void main(String[] args) {

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
