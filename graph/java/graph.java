import java.io.*;
import java.util.*;


/**
 * graph
 */
public class Graph {
	private int V; // no of vertices
	private LinkedList<Integer> adj[]; //adjaceny list
 
	Graph(int v) {
		V = v;
		adj = new LinkedList[v]; // initialize LinkedListArray
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList(); //initialize each LinkedList
		}
	}
	
	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void BFS(int s) {
		boolean visited[] = new boolean[V]; // initialized visited array
		LinkedList<Integer> queue = new LinkedList<Integer>(); //initialize queue for BFS

		visited[s] = true; // mark the current node as visitied
		queue.add(s); // enqueue the current node

		while (!queue.isEmpty())  {
			s = queue.poll();
			System.out.println(s + " ");
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		
		g.BFS(2);
	}
}