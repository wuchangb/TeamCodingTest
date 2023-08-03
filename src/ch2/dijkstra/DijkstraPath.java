package ch2.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int distance;
    String name;

    public Edge(int distance, String name) {
        this.distance = distance;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "distance=" + distance +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Edge o) {
        return this.distance - o.distance;
    }
}

public class DijkstraPath {

    public HashMap<String, Integer> dijkstraFunc(HashMap<String, ArrayList<Edge>> graph, String start) {
        Edge edgeNode;
        int currDistance, adjDistance;
        String currNode, adjName;
        Edge adjacentNode;
        ArrayList<Edge> nodeList = new ArrayList<>();
        HashMap<String, Integer> distances = new HashMap<>();
        for (String key : distances.keySet()) {
            distances.put(key, Integer.MAX_VALUE);
        }

        distances.put(start, 0);

        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(distances.get(start), start));

        while (priorityQueue.size() > 0) {
            edgeNode = priorityQueue.poll();
            currDistance = edgeNode.distance;
            currNode = edgeNode.name;

            if (distances.get(currNode) < currDistance) {
                continue;
            }

            nodeList = graph.get(currNode);
            for (int i = 0; i < nodeList.size(); i++) {
                adjacentNode = nodeList.get(i);
                adjDistance = adjacentNode.distance;
                adjName = adjacentNode.name;

                if (currDistance + adjDistance < distances.get(adjName)) {
                    distances.put(adjName, currDistance + adjDistance);
                    priorityQueue.add(new Edge(currDistance + adjDistance, adjName));
                }
            }
        }
        return distances;
    }

    public static void main(String[] args) {
        HashMap<String, ArrayList<Edge>> graph = new HashMap<String, ArrayList<Edge>>();
        graph.put("A", new ArrayList<Edge>(Arrays.asList(new Edge(8, "B"), new Edge(1, "C"), new Edge(2, "D"))));
        graph.put("B", new ArrayList<Edge>());
        graph.put("C", new ArrayList<Edge>(Arrays.asList(new Edge(5, "B"), new Edge(2, "D"))));
        graph.put("D", new ArrayList<Edge>(Arrays.asList(new Edge(3, "E"), new Edge(5, "F"))));
        graph.put("E", new ArrayList<Edge>(Arrays.asList(new Edge(1, "F"))));
        graph.put("F", new ArrayList<Edge>(Arrays.asList(new Edge(5, "A"))));

        DijkstraPath dijkstra = new DijkstraPath();
        System.out.println(dijkstra.dijkstraFunc(graph, "A"));
    }
}
