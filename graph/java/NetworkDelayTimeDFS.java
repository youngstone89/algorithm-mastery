import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.util.Pair;

public class NetworkDelayTimeDFS {

    static Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();

    private static void DFS(int[] signalRecieveAt, int currNode, int currTime) {
        // we need to find the shortest time to reach currNode
        // if currTime is greater than what we have found
        // simply return
        if (currTime > signalRecieveAt[currNode]) {
            return;
        }
        signalRecieveAt[currNode] = currTime;

        // check if currNode exists in adjacency list
        if (!adj.containsKey(currNode)) {
            return;
        }
        // perform DFS for each ofthe adjacent nodes
        for (Pair<Integer, Integer> adjNode : adj.get(currNode)) {
            int travleTime = adjNode.getKey();
            int neighborNode = adjNode.getValue();
            DFS(signalRecieveAt, neighborNode, currTime + travleTime);
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        // build adjacency list
        // loop n times
        for (int[] time : times) {
            int source = time[0];
            int dest = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(source, new ArrayList<>());
            adj.get(source).add(new Pair(travelTime, dest));
        }

        // sort in ascending order
        // a.getKey returns Pair's travel Time
        // sorting using travel time comparison
        // in ascending orders
        for (int node : adj.keySet()) {
            Collections.sort(adj.get(node), (a, b) -> a.getKey() - b.getKey());
        }

        // initialize signalRecievedAt
        // with max value to indicate no signal arrived
        int[] signalRecievedAt = new int[n + 1];
        Arrays.fill(signalRecievedAt, Integer.MAX_VALUE);
        // start from node k, and 0
        // since from k to itself, it doesn't take any time to reach
        DFS(signalRecievedAt, k, 0);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalRecievedAt[node]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    public static void main(String[] args) {
        // int[][] times = new int[][] {
        // { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 }
        // };
        // we are going to find the timestamp at which the last node receives the signal
        // this way we can find the maximum time required by all nodes to receive signal
        // k : the starting point of signal
        // n : number of nodes in the network
        // System.out.println(networkDelayTime(times, 4, 2));

        int[][] times = new int[][] {
                { 1, 2, 1 },
        };
        System.out.println(networkDelayTime(times, 2, 1));
    }
}

// java.lang.StackOverflowError

// at line 338,java.base/java.util.HashMap.hash
// at line 568,java.base/java.util.HashMap.getNode
// at line 594,java.base/java.util.HashMap.containsKey
// at line 39,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS at line 45,
// Solution.DFS
// at line 45,Solution.
// DFS