package org.example;

import com.google.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Vertex implements Comparable<Vertex> {
    private final int id;
    private LatLng region;
    private final String name;
    private final List<Edge> edges;
    public double dist =Double.MAX_VALUE;

    private Map<String, Integer> stock;

    private int priority;
    public Vertex prev;



    public Vertex(int id, LatLng region, String name) {
        this.id = id;
        this.setRegion(region);
        this.name = name;
        this.edges = new ArrayList<>();
        this.stock = new HashMap<>();
        prev = null;
        priority = 0;

    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStock(String item) {
        return stock.getOrDefault(item, 0);
    }

    public void setStock(String item, int quantity) {
        stock.put(item, quantity);
    }

    public int compareTo(Vertex other) {
        return Double.compare(dist, other.dist);
    }

    public int getId() {
        return id;
    }

    public LatLng getRegion() {
        return region;
    }

    public void setRegion(LatLng region) {
        this.region = region;
    }

    public String getName() {
        return name;
    }

    public void addEdge(Vertex destination, double weight) {
        edges.add(new Edge(getName(),this, destination, weight));
    }

    public String toString() {
        return ""+ region ;
    }



}

