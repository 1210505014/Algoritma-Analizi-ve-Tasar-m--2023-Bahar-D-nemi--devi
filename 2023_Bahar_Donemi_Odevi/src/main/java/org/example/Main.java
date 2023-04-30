package org.example;

import com.google.maps.DirectionsApi;
import com.google.maps.DirectionsApiRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DirectionsLeg;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.DirectionsRoute;
import com.google.maps.model.LatLng;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Main {
    public static void main(String[] args) {

        String apiKey = "AIzaSyBQLfg9gN2If17I3PGK6L1jOfW-n0wHItk";
        GeoApiContext context = new GeoApiContext.Builder().apiKey(apiKey).build();

        LatLng start = new LatLng(36.59323491052925, 36.16907367012717);
        LatLng end1 = new LatLng(36.58619709335186, 36.152649850338896);
        LatLng end2 = new LatLng(36.572952560661726, 36.190210829596616);
        LatLng end4 = new LatLng(36.493431662737144, 36.367544468706825);
        LatLng end5 = new LatLng(36.491951286844, 36.36921352768779);
        LatLng end6 = new LatLng(36.22920650471166, 36.122556213113484);
        LatLng end8 = new LatLng(36.21494804382459, 36.12897207024171);
        LatLng end9 = new LatLng(36.21273369059351, 36.13696485324579);
        LatLng end11 = new LatLng(36.11438122810955, 36.246727809804995);
        LatLng end12 = new LatLng(36.25771580288928, 36.56313184052891);
        LatLng end13 = new LatLng(36.26232467759256, 36.57273683087788);


        Vertex startNode = new Vertex(0, start, "İskenderun Limanı");
        Vertex endNode1 = new Vertex(1, end1, "Acil Barınma Noktası - İskenderun Gençlik Merkezi");
        Vertex endNode2 = new Vertex(2, end2, "Acil Barınma Noktası - İskenderun Spor Salonu");
        Vertex endNode4 = new Vertex(4, end4, "Acil Barınma Noktası - Kırıkhan Spor Salonu");
        Vertex endNode5 = new Vertex(5, end5, "Acil Barınma Noktası - Kırıkhan Gençlik Merkezi");
        Vertex endNode6 = new Vertex(6, end6, "Acil Barınma Noktası - Merkez Cimnastik Spor Salonu");
        Vertex endNode8 = new Vertex(8, end8, "Acil Barınma Noktası - TOKİ Spor Salonu");
        Vertex endNode9 = new Vertex(9, end9, "Acil Barınma Noktası - Merkez Spor Salonu");
        Vertex endNode11 = new Vertex(11, end11, "Acil Barınma Noktası - Altınözü Gençlik Merkezi");
        Vertex endNode12 = new Vertex(12, end12, "Acil Barınma Noktası - Reyhanlı Gençlik Merkezi");
        Vertex endNode13 = new Vertex(13, end13, "Acil Barınma Noktası - Reyhanlı Spor Salonu");

        startNode.setStock("sağlık malzemesi", 100);
        startNode.setStock("temel gıda", 100);
        startNode.setStock("ısınma gereci", 70);
        startNode.setStock("giyecek", 70);

        Graph graph = new Graph();
        graph.addVertex(startNode);
        graph.addVertex(endNode1);
        graph.addVertex(endNode2);
        graph.addVertex(endNode4);
        graph.addVertex(endNode5);
        graph.addVertex(endNode6);
        graph.addVertex(endNode8);
        graph.addVertex(endNode9);
        graph.addVertex(endNode11);
        graph.addVertex(endNode12);
        graph.addVertex(endNode13);

        graph.addEdge(new Edge("Edge 1", startNode, endNode1, getDistance(context, start, end1)));
        graph.addEdge(new Edge("Edge 2", startNode, endNode2, getDistance(context, start, end2)));
        graph.addEdge(new Edge("Edge 4", startNode, endNode4, getDistance(context, start, end4)));
        graph.addEdge(new Edge("Edge 5", startNode, endNode5, getDistance(context, start, end5)));
        graph.addEdge(new Edge("Edge 6", startNode, endNode6, getDistance(context, start, end6)));
        graph.addEdge(new Edge("Edge 8", startNode, endNode8, getDistance(context, start, end8)));
        graph.addEdge(new Edge("Edge 9", startNode, endNode9, getDistance(context, start, end9)));
        graph.addEdge(new Edge("Edge 11", startNode, endNode11, getDistance(context, start, end11)));
        graph.addEdge(new Edge("Edge 12", startNode, endNode12, getDistance(context, start, end12)));
        graph.addEdge(new Edge("Edge 13", startNode, endNode13, getDistance(context, start, end13)));

        // Konumlara malzeme stoklama
        Vertex loc1 = graph.getVertexByName("İskenderun Limanı");
        loc1.setStock("temel gıda", 100);
        loc1.setStock("giyecek", 70);
        loc1.setStock("sağlık malzemesi", 100);
        loc1.setStock("ısınma gereci", 70);

        int[] stocks = new int[] {100, 100, 70, 70};
        Map<String, Integer> needs = new HashMap<String, Integer>();
        // Tüm konumlara malzeme dağıtımı yapma
        for (Vertex vertex : graph.getVertices()) {
            if (vertex.getName().equals("İskenderun Limanı")) {
                continue;
            }

            graph.calculatePathForNeeds(loc1,needs, stocks);

        }
        graph.printStocks();

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(startNode);

        System.out.println("En Kısa Yol:");
        for (Vertex vertex : Arrays.asList(endNode1, endNode2, endNode4, endNode5, endNode6, endNode8, endNode9, endNode11, endNode12, endNode13)) {
            LinkedList<Vertex> path = dijkstra.getPath(vertex);
            if (path != null) {
                System.out.println(vertex.getName() + ": " + path);
            } else {
                System.out.println(vertex.getName() + ": Yol Bulunamadı.");
            }
        }
    }

    private static double getDistance(GeoApiContext context, LatLng origin, LatLng destination) {
        try {
            DirectionsApiRequest request = DirectionsApi.getDirections(context, origin.toString(), destination.toString());
            DirectionsResult result = request.await();
            DirectionsRoute route = result.routes[0];
            DirectionsLeg leg = route.legs[0];
            return leg.distance.inMeters / 1000.0;
        } catch (Exception e) {
            throw new RuntimeException("Error getting distance", e);
        }




    }
}


