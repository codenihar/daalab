import java.util.*;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer> adj[]; // Adjacency list representation

    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w) {
        adj[v].add(w);
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean visited[], Stack<Integer> stack) {
        // Mark the current node as visited.
        visited[v] = true;
        
        // Recur for all the vertices adjacent to this vertex
        for (Integer i : adj[v]) {
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        }
        
        // Push current vertex to stack which stores result
        stack.push(v);
    }

    // The function to do Topological Sort. It uses recursive topologicalSortUtil()
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;
        
        // Call the recursive helper function to store Topological Sort starting from all vertices one by one
        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);
        
        // Print contents of stack
        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    public static void main(String args[]) {
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        
        System.out.println("Topological sort of the given graph:");
        g.topologicalSort();
    }
}
