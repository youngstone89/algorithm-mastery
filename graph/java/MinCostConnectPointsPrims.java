import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostConnectPointsPrims {
    public static int minCostConnectPoints(int[][] points) {
        int len = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0 });
        Set<Integer> visited = new HashSet<>();
        int cost = 0;

        while (visited.size() < len) {
            int[] arr = pq.poll();
            int weight = arr[0];
            int curNode = arr[1];

            if (visited.contains(curNode))
                continue;

            visited.add(curNode);
            cost += weight;
            for (int nextNode = curNode + 1; nextNode < len; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight = Math.abs(points[curNode][0] - points[nextNode][0]) +
                            Math.abs(points[curNode][1] - points[nextNode][1]);
                    pq.offer(new int[] { nextWeight, nextNode });
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        int[][] points = new int[][] {
                { 0, 0 },
                { 2, 2 },
                { 3, 10 },
                { 5, 2 },
                { 7, 0 },
        };
        System.out.println(minCostConnectPoints(points));

        int[][] points2 = new int[][] {
                { 3, 12 },
                { -2, 5 },
                { -4, 1 },
        };
        System.out.println(minCostConnectPoints(points2));

    }
}
