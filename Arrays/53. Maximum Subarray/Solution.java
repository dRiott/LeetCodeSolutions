class Solution {
    // "Kadane's Algorithm"

    // Given an integer array nums, find the subarray with the largest sum, and return its sum.
    public int maxSubArray(int[] nums) {
        // any subarray whose sum is positive is worth keeping
        // Whenever the sum of the array is negative, we know the entire array is not worth keeping
        // so we'll reset it back to an empty array.

        int cur = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (cur < 0) {
                cur = 0;
            }
            cur += nums[i];
            max = Math.max(max, cur);
        }

        return max;
    }
}
