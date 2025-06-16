package graphs;

import java.util.*;

public class Graph {
    private int numberOfNodes = 0;
    private Map<String, List<String>> adjacentList = new HashMap<>();

    public void addVertex(String node) {
        if (!adjacentList.containsKey(node)) {
            adjacentList.put(node, new ArrayList<>());
            numberOfNodes++;
        }
    }

    public void addEdge(String node1, String node2) {
        // Ensure both nodes exist
        adjacentList.putIfAbsent(node1, new ArrayList<>());
        adjacentList.putIfAbsent(node2, new ArrayList<>());

        // Add the edge (undirected)
        if (!adjacentList.get(node1).contains(node2)) {
            adjacentList.get(node1).add(node2);
        }
        if (!adjacentList.get(node2).contains(node1)) {
            adjacentList.get(node2).add(node1);
        }
    }

    public void showConnections() {
        for (String node : adjacentList.keySet()) {
            List<String> nodeConnections = adjacentList.get(node);
            String connections = String.join(" ", nodeConnections);
            System.out.println(node + "-->" + connections);
        }
    }

    public static void main(String[] args) {
        Graph myGraph = new Graph();
        myGraph.addVertex("0");
        myGraph.addVertex("1");
        myGraph.addVertex("2");
        myGraph.addVertex("3");
        myGraph.addVertex("4");
        myGraph.addVertex("5");
        myGraph.addVertex("6");

        myGraph.addEdge("3", "1");
        myGraph.addEdge("3", "4");
        myGraph.addEdge("4", "2");
        myGraph.addEdge("4", "5");
        myGraph.addEdge("1", "2");
        myGraph.addEdge("1", "0");
        myGraph.addEdge("0", "2");
        myGraph.addEdge("6", "5");

        myGraph.showConnections();
    }
}

