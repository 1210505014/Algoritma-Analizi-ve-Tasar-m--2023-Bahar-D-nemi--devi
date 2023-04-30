package org.example;
import java.util.*;

public class DijkstraAlgorithm {

    private final List<Vertex> nodes;
    private final List<Edge> edges;
    private Set<Vertex> visitedNodes;
    private PriorityQueue<Vertex> unvisitedNodes;
    private Map<Vertex, Vertex> previousNodes;
    private Map<Vertex, Double> distances;

    public DijkstraAlgorithm(Graph graph) {
        this.nodes = new ArrayList<>(graph.getVertices());
        this.edges = new ArrayList<>(graph.getEdges());
    }

    public void execute(Vertex source) {
        visitedNodes = new HashSet<>();
        unvisitedNodes = new PriorityQueue<>();
        previousNodes = new HashMap<>();
        distances = new HashMap<>();

        distances.put(source, 0.0);
        unvisitedNodes.add(source);

        while (!unvisitedNodes.isEmpty()) {
            Vertex current = unvisitedNodes.poll();
            visitedNodes.add(current);
            findMinimumDistances(current);
        }
    }

    private void findMinimumDistances(Vertex node) {
        List<Vertex> neighbors = getNeighbors(node);
        for (Vertex neighbor : neighbors) {
            double edgeDistance = getEdgeDistance(node, neighbor);
            double newDistance = distances.get(node) + edgeDistance;
            if (newDistance < distances.getOrDefault(neighbor, Double.MAX_VALUE)) {
                distances.put(neighbor, newDistance);
                previousNodes.put(neighbor, node);
                unvisitedNodes.add(neighbor);
            }
        }
    }

    private List<Vertex> getNeighbors(Vertex node) {
        List<Vertex> neighbors = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(node)) {
                neighbors.add(edge.getDestination());
            }
        }
        return neighbors;
    }

    private double getEdgeDistance(Vertex node, Vertex neighbor) {
        for (Edge edge : edges) {
            if (edge.getSource().equals(node) && edge.getDestination().equals(neighbor)) {
                return edge.getWeight();
            }
        }
        throw new RuntimeException("Invalid edge");
    }

    public LinkedList<Vertex> getPath(Vertex target) {
        LinkedList<Vertex> path = new LinkedList<>();
        Vertex step = target;
        if (previousNodes.get(step) == null) {
            return null;
        }
        path.add(step);
        while (previousNodes.get(step) != null) {
            step = previousNodes.get(step);
            path.add(step);
        }
        Collections.reverse(path);
        return path;
    }

}




