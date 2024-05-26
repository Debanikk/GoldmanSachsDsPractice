package com.wildfire.GoldmanSachsDsPractice.graphPractice;

public class GraphEdge {
    private int source;
    private int destination;
    private int weight;

    public GraphEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return this.source;
    }

    public int getDestination() {
        return this.destination;
    }

    public int getWeight() {
        return this.weight;
    }
}
