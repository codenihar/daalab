import java.util.*;

class DFS {
    private int V; // Number of vertices
    private List<Integer>[] adj; // Adjacency list

    public DFS(int V) {
        this.V = V;
        adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // For undirected graph, add the reverse edge as well
    }

    public boolean isConnected() {
        boolean[] visited = new boolean[V];
        dfs(0, visited);

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false; // If any vertex is not visited, the graph is not connected
            }
        }
        return true; // All vertices are visited, so the graph is connected
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        DFS graph = new DFS(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3); 

        boolean isConnected = graph.isConnected();
        System.out.println("Is the graph connected? " + isConnected);
    }
}