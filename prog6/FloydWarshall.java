class FloydWarshall {
    final static int INF = 99999;

    void floydWarshall(int graph[][], int V) {
        int dist[][] = new int[V][V];
        int i, j, k;

        // Initialize the solution matrix with the given graph
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // Update dist[][] to find the shortest path
        for (k = 0; k < V; k++) {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++) {
                // Pick all vertices as destination for the above picked source
                for (j = 0; j < V; j++) {
                    // If vertex k is on the shortest path from i to j,
                    // then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }

        // Print the shortest distances
        printSolution(dist, V);
    }

    void printSolution(int dist[][], int V) {
        System.out.println("Shortest distances between every pair of vertices:");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { {0, 5, INF, 10},
                          {INF, 0, 3, INF},
                          {INF, INF, 0, 1},
                          {INF, INF, INF, 0}
                        };
        int V = 4;
        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph, V);
    }
}
