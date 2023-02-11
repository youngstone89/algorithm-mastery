import java.util.LinkedList;
import java.util.Iterator;

public class DepthFirstSearchDisconnectedGraph {
    private int V;
    private LinkedList<Integer>[] adj;
    public DepthFirstSearchDisconnectedGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int index = 0; index < adj.length; index++) {
            adj[index] = new LinkedList<>();
        }
    }

    void addEdge(int index, int w) {
        adj[index].add(w);
    }
    void DFS() {

        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
            }
        }
    }

    void DFSUtil(int index, boolean[] visited) {
        visited[index] = true;
        System.out.println(index + "");

        Iterator<Integer> i = adj[index].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    public static void main(String[] args) {
        DepthFirstSearchDisconnectedGraph g = new DepthFirstSearchDisconnectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.DFS();
    }
}
