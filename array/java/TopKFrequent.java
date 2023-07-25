import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {

    /**
     * Time Complexity: O(nlog(k))
     * Space Complexity: O(n)
     */
    public int[] topKFrequent1(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            if (pq.size() > k)
                pq.poll();
        }
        int i = k;
        while (!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }

    public static void main(String[] args) {
        TopKFrequent tkf = new TopKFrequent();
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3, 4, 5, 6, 6, 6, 6, 6 };
        for (int num : tkf.topKFrequent1(nums, 2)) {
            System.out.println(num);
        }
        ;

    }

}
