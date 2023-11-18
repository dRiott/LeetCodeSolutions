/** 
 * Learned:
 *   - This is a cool sliding window technique. The intuition optimizes doling out the k increment operations.
 *   - After incrementing k operations, you'd have a final result sum, expressed as frequency*target...
 *   - To get to that end state, you need to take a window of nums to the left of target and increment them.
 *   - How many operations is that? It's the difference between the final result sum, and the sum of those numbers presently.
 *   - Below that's "sumNumsInWindow", and final result sum is "endSum".
 *   - If that value is too large, we shrink the window, reduce our sumNumsInWindow, and consume a smaller number of operations.
 */
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
