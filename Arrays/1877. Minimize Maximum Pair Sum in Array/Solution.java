class Solution {
    public int minPairSum(int[] nums) {
        // divide nums into pairs
        // don't skip any value in nums, must use all
        // maximum pair sum is minimized
        int max = Integer.MIN_VALUE;
        if (nums.length < 2) return max;
        Arrays.sort(nums);
        int i = 0, j = nums.length -1;
        
        while (i < j) {
            max = Math.max(max, nums[i++] + nums[j--]);
        }
        return max;
    }
}
