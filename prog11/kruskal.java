import java.util.Arrays;
import java.util.Comparator;

class Edge {
    int src, dest, weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

public class kruskal {

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }

    public static void union(int[] parent, int[] rank, int x, int y) {
        int xRoot = find(parent, x);
        int yRoot = find(parent, y);

        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot]++;
        }
    }

    public static void kruskalMST(Edge[] edges, int V) {
        Arrays.sort(edges, Comparator.comparingInt(o -> o.weight));

        Edge[] result = new Edge[V - 1];
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int e = 0;
        int i = 0;

        while (e < V - 1) {
            Edge nextEdge = edges[i++];
            int x = find(parent, nextEdge.src);
            int y = find(parent, nextEdge.dest);

            if (x != y) {
                result[e++] = nextEdge;
                union(parent, rank, x, y);
            }
        }

        System.out.println("Edge   Weight");
        for (i = 0; i < V - 1; i++) {
            System.out.println(result[i].src + " - " + result[i].dest + "    " + result[i].weight);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        Edge[] edges = new Edge[7];

        edges[0] = new Edge(0, 1, 2);
        edges[1] = new Edge(0, 3, 6);
        edges[2] = new Edge(1, 3, 8);
        edges[3] = new Edge(1, 2, 3);
        edges[4] = new Edge(1, 4, 5);
        edges[5] = new Edge(2, 4, 7);
        edges[6] = new Edge(3, 4, 9);

        kruskalMST(edges, V);
    }
}