package org.example;

public class Edge {
    private final Vertex source;
    private final Vertex destination;
    private final double weight;

    public Edge(String edgeName,Vertex source, Vertex destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}


