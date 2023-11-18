class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int max = 0;
        int left = 0;
        int sumNumsInWindow = 0;
        for (int right = 0; right < nums.length; right++) {
            int target = nums[right];
            sumNumsInWindow += target;

            // shrink window until k operations can make left values match target
            // windowSize = (right - left) + 1;
            // endSum = target * windowSize;
            // while endSum - sumNumsInWindow > k...
            while ((right - left + 1)*target - sumNumsInWindow > k) {
                sumNumsInWindow -= nums[left++];
            }

            max = Math.max(max, right - left + 1); // window size for the frequency count
        }
        return max;
    }
}
