import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3 };
        System.out.println(ContainsDuplicate.containsDuplicate(nums));
        ;

    }
}