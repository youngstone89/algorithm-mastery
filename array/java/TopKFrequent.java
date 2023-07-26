import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int size = map.size();
        int[] keys = new int[size];
        int i = 0;
        for (int key : map.keySet()) {
            keys[i++] = key;
        }
        select(keys, map, 0, size - 1, size - k);
        return Arrays.copyOfRange(keys, size - k, size);
    }

    private void select(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int kSmallest) {
        while (left != right) {
            int pivot = partition(keys, map, left, right, (left + right) / 2);

            if (kSmallest == pivot)
                return;

            if (kSmallest < pivot)
                right = pivot - 1;
            else
                left = pivot + 1;
        }
    }

    private int partition(
            int[] keys,
            Map<Integer, Integer> map,
            int left,
            int right,
            int pivot) {
        int pivotValue = map.get(keys[pivot]);
        swap(keys, pivot, right);
        int index = left;

        for (int i = left; i <= right; i++)
            if (map.get(keys[i]) < pivotValue) {
                swap(keys, i, index);
                index++;
            }
        swap(keys, right, index);
        return index;
    }

    private void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer> bucket[] = new ArrayList[nums.length + 1];

        for (int num : nums)
            count.merge(num, 1, Integer::sum);

        for (int key : count.keySet()) {
            int freq = count.get(key);
            if (bucket[freq] == null)
                bucket[freq] = new ArrayList<>();
            bucket[freq].add(key);
        }

        int index = 0;
        int[] res = new int[k];
        for (int i = nums.length; i >= 0; i--)
            if (bucket[i] != null)
                for (int val : bucket[i]) {
                    res[index++] = val;
                    if (index == k)
                        return res;
                }
        return res;
    }

    public static void main(String[] args) {
        TopKFrequent tkf = new TopKFrequent();
        int[] nums = new int[] { 1, 1, 1, 2, 2, 3 };
        // for (int num : tkf.topKFrequent1(nums, 2)) {
        // System.out.println(num);
        // }
        for (int num : tkf.topKFrequent3(nums, 2)) {
            System.out.println(num);
        }

    }

}
