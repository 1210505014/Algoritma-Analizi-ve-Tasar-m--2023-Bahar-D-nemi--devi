package org.example;

import java.util.ArrayList;
import java.util.List;

public class Node {
    //private Location location;
    private List<Node> neighbors;
    private double distance;
    private Node previous;


    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node node) {
        neighbors.add(node);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}