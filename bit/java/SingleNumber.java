public class SingleNumber {

    public static int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 2, 2, 1, 1 };
        System.out.println(SingleNumber.singleNumber(nums));
    }

}
