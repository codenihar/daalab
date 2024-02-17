import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge {
    int target;
    int weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class dij {
    public static void dijkstra(ArrayList<ArrayList<Edge>> graph, int source) {
        int V = graph.size();
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        minHeap.add(new Edge(source, 0));

        while (!minHeap.isEmpty()) {
            Edge current = minHeap.poll();
            int u = current.target;

            for (Edge neighbor : graph.get(u)) {
                int v = neighbor.target;
                int alt = dist[u] + neighbor.weight;

                if (alt < dist[v]) {
                    dist[v] = alt;
                    minHeap.add(new Edge(v, alt));
                }
            }
        }

        // Print the shortest distances from the source node
        System.out.println("Shortest distances from source node " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("Node " + i + ": " + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Edge>> graph = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(2, 4));
        graph.get(1).add(new Edge(2, 1));
        graph.get(1).add(new Edge(3, 7));
        graph.get(2).add(new Edge(3, 3));
        graph.get(4).add(new Edge(3, 2));

        int source = 4;
        dijkstra(graph, source);
    }
}