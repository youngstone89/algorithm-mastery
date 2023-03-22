public class FloydWarshall {
    private static final int INF = Integer.MAX_VALUE, V = 4 ;
    void floydWarshall(int[][] graph){
        int i, j, k;
        for (k = 0; k < V; k++) {
            // loop through all vertices as source
            for (i = 0; i < V; i++) {
                // pick all the vertices as destination vertex
                for (j = 0; j < V; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        printSolution(graph);
    }
    
    void printSolution(int dist[][])
    {
        System.out.println(
            "The following matrix shows the shortest "
            + "distances between every pair of vertices");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        /* Let us create the following weighted graph
           10
        (0)------->(3)
        |         /|\
        5 |          |
        |          | 1
        \|/         |
        (1)------->(2)
           3           */
        int graph[][] = {
            { 0, 5, INF, 10 },
            { INF, 0, 3, INF },
            { INF, INF, 0, 1 },
                { INF, INF, INF, 0 } };
        FloydWarshall fw = new FloydWarshall();

        fw.floydWarshall(graph);
    }
}
