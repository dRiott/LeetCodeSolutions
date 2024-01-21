class Solution {
    public int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length];
        return dp(nums, memo, 0);
    }

    private int dp(int[] nums, Integer[] memo, int i) {
        if (i >= nums.length) {
            return 0;
        }

        if (memo[i] != null) {
            return memo[i];
        }

        int rob = nums[i] + dp(nums, memo, i+2);
        int skip = dp(nums, memo, i+1);

        return memo[i] = Math.max(rob, skip);
    }
}
