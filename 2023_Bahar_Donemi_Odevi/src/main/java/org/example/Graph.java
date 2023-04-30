package org.example;

import java.util.*;

public class Graph {
    private final List<Vertex> vertices;
    private final List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        vertices.add(vertex);
    }

    public void addEdge(Edge edge) {
        Vertex source = edge.getSource();
        Vertex destination = edge.getDestination();
        if (!vertices.contains(source)) {
            vertices.add(source);
        }
        if (!vertices.contains(destination)) {
            vertices.add(destination);
        }
        edges.add(edge);
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public Map<Vertex, Double> getAdjacentVertices(Vertex vertex) {
        Map<Vertex, Double> adjacentVertices = new HashMap<>();
        for (Edge edge : edges) {
            if (edge.getSource().equals(vertex)) {
                adjacentVertices.put(edge.getDestination(), edge.getWeight());
            }
        }
        return adjacentVertices;
    }


    public void calculatePathForNeeds(Vertex startVertex, Map<String, Integer> needs, int[] stocks) {
        String[] needNames = new String[]{"sağlık malzemesi", "temel gıda", "ısınma gereci", "giyecek"};
        int[] priorities = new int[]{1, 2, 3, 4};

        // ihtiyaçlar öncelik sırasına göre kontrol ediliyor
        for (int priority : priorities) {
            String currentNeed = null;
            int currentStock = 0;
            for (String needName : needs.keySet()) {
                if (needs.get(needName) == priority) {
                    currentNeed = needName;
                    currentStock = stocks[priority - 1];
                    break;
                }
            }

            if (currentNeed != null) {
                boolean allNeedsMet = true;
                for (Vertex vertex : vertices) {
                    // En yakın konuma gidilerek ihtiyaç malzemesi satın alınıyor
                    if (vertex.getName().equals(startVertex.getName())) {
                        continue;
                    }

                    double distance = vertex.dist;
                    if (distance == Double.MAX_VALUE) {
                        continue;
                    }

                    if (vertex.getStock(currentNeed) < 1) {
                        int requiredStock = 1;
                        if (currentStock > 0) {
                            requiredStock = Math.min(currentStock, 5);
                        }

                        currentStock -= requiredStock;
                        if (currentStock <= 0) {
                            needs.remove(currentNeed);
                            allNeedsMet = needs.isEmpty();
                            break;
                        }
                    }
                }

                if (!allNeedsMet) {
                    System.out.println("Bu ihtiyaç karşılanamadı: " + currentNeed);
                    break;
                }
            }
        }

    }


    public Vertex getVertexByName(String name) {
        for (Vertex vertex : vertices) {
            if (vertex.getName().equals(name)) {
                return vertex;
            }
        }
        return null;
    }

    public void printStocks() {
        for (Vertex vertex : vertices) {
            System.out.println(vertex.getName() + ": " + vertex.getStock("sağlık malzemesi"));
            System.out.println(vertex.getName() + ": " + vertex.getStock("temel gıda"));
            System.out.println(vertex.getName() + ": " + vertex.getStock("ısınma gereci"));
            System.out.println(vertex.getName() + ": " + vertex.getStock("giyecek"));
        }
    }

}




