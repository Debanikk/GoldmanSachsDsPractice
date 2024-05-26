package com.wildfire.GoldmanSachsDsPractice.graphPractice;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private int vertices;
    private List<GraphEdge>[] adjacencyList;

    public WeightedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList[vertices];

        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }

    /// add a Directed Edge for the vertices
    public void addDirectedEdge(int source, int destination, int weight) {
        GraphEdge edge = new GraphEdge(source, destination, weight);
        adjacencyList[source].add(edge);
    }

    /// add UnDirected Edges for the vertices
    public void addUnDirectedEdge(int source, int destination, int weight) {
        // create graphEdge for both S -> D and D -> S
        GraphEdge sourceToDestinationEdge = new GraphEdge(source, destination, weight);
        GraphEdge destinationToSourceEdge = new GraphEdge(destination, source, weight);

        // add both GraphEdge to the adjacencyList
        adjacencyList[source].add(sourceToDestinationEdge);
        adjacencyList[destination].add(destinationToSourceEdge);
    }


    // returns the adjacencyList to traverse graph
    public List<GraphEdge>[] getVertices() {
        return adjacencyList;
    }

    /// remove edge from a directed graph
    public void removeDirectedEdge(int source, int destination) {
        for(GraphEdge edge : adjacencyList[source]) {
            if(edge.getDestination() == destination) {
                adjacencyList[source].remove(edge);
                break;
            }
        }
    }

    /// removes edge from an undirected graph
    public void removeUndirectedEdge(int source, int destination) {
        removeDirectedEdge(source, destination);
        removeDirectedEdge(destination, source);
    }
}
