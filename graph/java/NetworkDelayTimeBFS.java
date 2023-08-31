import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import javafx.util.Pair;

public class NetworkDelayTimeBFS {

    static Map<Integer, List<Pair<Integer, Integer>>> adj = new HashMap<>();
    static Queue<Pair<Integer, Integer>> queue = new LinkedList();

    private static void BFS(int[] signalRecieveAt) {

        while (!queue.isEmpty()) {
            Pair<Integer, Integer> node = queue.poll();
            int currTime = node.getKey();
            int currNode = node.getValue();
            if (!adj.containsKey(currNode)) {
                continue;
            }
            // traverse neighbor nodes
            for (Pair<Integer, Integer> edge : adj.get(currNode)) {
                int travelTime = edge.getKey();
                int neighborNode = edge.getValue();
                if (travelTime < signalRecieveAt[neighborNode]) {
                    queue.offer(new Pair<>(travelTime + currTime, neighborNode));
                    signalRecieveAt[neighborNode] = travelTime + currTime;
                }
            }
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        // creating adjacency list
        for (int[] time : times) {
            int src = time[0];
            int dst = time[1];
            int travelTime = time[2];
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(new Pair<>(travelTime, dst));
        }
        // because index starts from 1
        int[] signalReceivedAt = new int[n + 1];
        Arrays.fill(signalReceivedAt, Integer.MAX_VALUE);

        signalReceivedAt[k] = 0;
        queue.offer(new Pair<>(0, k));
        BFS(signalReceivedAt);

        int answer = Integer.MIN_VALUE;
        for (int node = 1; node <= n; node++) {
            answer = Math.max(answer, signalReceivedAt[node]);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;

    }

    public static void main(String[] args) {

        int[][] times = new int[][] {
                { 2, 1, 1 },
                { 2, 3, 1 },
                { 3, 4, 1 },
        };
        System.out.println(networkDelayTime(times, 4, 2));
    }
}

// Time Limit Exceeded
