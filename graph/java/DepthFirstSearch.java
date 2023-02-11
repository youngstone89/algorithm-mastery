import java.util.Iterator;
import java.util.LinkedList;

class DepthFirstSearch {
    private int V;
    private LinkedList<Integer> adj[];
    
    DepthFirstSearch(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int index = 0; index < adj.length; index++) {
            adj[index] = new LinkedList<>();
        }
    }
    
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        // mark visited
        visited[v] = true;

        // print out the visited value
        System.out.println(v + "");

        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    void DFS(int v) {
        boolean[] visited = new boolean[V];
        DFSUtil(v, visited);
    }

    public static void main(String[] args) {
        DepthFirstSearch dfs = new DepthFirstSearch(4);

        dfs.addEdge(0, 1);
        dfs.addEdge(0, 2);
        dfs.addEdge(1, 2);
        dfs.addEdge(2, 0);
        dfs.addEdge(2, 3);
        dfs.addEdge(3, 3);

        System.out.println("Folowing is Depth First Traversal starting from vertext 2");
        dfs.DFS(2);
    }
}
