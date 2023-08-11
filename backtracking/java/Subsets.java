import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(ans, 0, nums, subset);
        return ans;
    }

    public static void helper(List<List<Integer>> ans, int start, int[] nums, List<Integer> subset) {
        if (start >= nums.length) {
            // should copy value to avoid modification of original instance in final list
            ans.add(new ArrayList<>(subset));
        } else {

            // decision to include
            subset.add(nums[start]);
            helper(ans, start + 1, nums, subset);

            // decision not to include
            subset.remove(subset.size() - 1);
            helper(ans, start + 1, nums, subset);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3 };
        List<List<Integer>> answer = Subsets.findSubsets(nums);
        for (List<Integer> s : answer) {
            System.out.println(s);
        }
    }
}
