public class TransitiveClosure {

    private int vertices;
    private boolean[][] adjacencyMatrix;

    public TransitiveClosure(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new boolean[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = true;
    }

    public void warshall() {
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    adjacencyMatrix[i][j] = adjacencyMatrix[i][j] || (adjacencyMatrix[i][k] && adjacencyMatrix[k][j]);
                }
            }
        }
    }

    public void printTransitiveClosure() {
        System.out.println("Transitive Closure Matrix:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] ? "1 " : "0 ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TransitiveClosure graph = new TransitiveClosure(4);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // Computing transitive closure using Warshall's algorithm
        graph.warshall();

        // Printing the transitive closure matrix
        graph.printTransitiveClosure();
    }
}
