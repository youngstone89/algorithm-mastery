import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class CheapestFlightsKStopsBFS {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        // creat adjacency list
        for (int[] sdcArr : flights) {
            // element at index 0 is src
            // if key doesn't contain any value, initialize ArrayList
            // else add to the ArrayList
            adj.computeIfAbsent(sdcArr[0], value -> new ArrayList<>())
                    .add(new int[] { sdcArr[1], sdcArr[2] });
        }
        // initialize dist array to store min distance from src to dst
        int[] dist = new int[n];

        // fill the dist array with max value to find minimum distance in repetivie
        // comparison
        Arrays.fill(dist, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        // node, distance pair
        q.offer(new int[] { src, 0 });

        int stops = 0;
        // loop until queue is empty and stops reached at most k
        while (!q.isEmpty() && stops <= k) {
            // iterate over current level
            int[] temp = q.poll();
            int node = temp[0];
            int distance = temp[1];

            // skip if adjacent list doesn't have src/dst information
            if (!adj.containsKey(node)) {
                continue;
            }
            // traverse neighbors
            for (int[] dstCostArr : adj.get(node)) {
                int neighbor = dstCostArr[0];
                int cost = dstCostArr[1];

                // cost is the price of edge to reach node ( from source to dest )
                // distance is is the minmal cost to reach src
                if (cost + distance >= dist[neighbor]) {
                    continue;
                }
                // update minimal cost distance
                dist[neighbor] = cost + distance;
                q.offer(new int[] { neighbor, dist[neighbor] });
            }
            // increase stops count
            stops++;
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(CheapestFlightsKStopsBFS.findCheapestPrice(n, flights, src, dst, k));
        ;
    }
}