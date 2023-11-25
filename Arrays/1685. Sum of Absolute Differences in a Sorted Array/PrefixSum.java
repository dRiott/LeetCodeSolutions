/**
 * Learned:
 *   - Key insight: splitting the problem into two pieces to treat left and right sides separately
 */
class PrefixSum {
    
    public int[] getSumAbsoluteDifferences(int[] nums) {

        // how do we find leftSum and rightSum?
        // use prefix sums to find the sum of any subarray in O(1)
        int n = nums.length;
        int[] prefixSum = new int[n];
        // where prefixSum[i] is sum of all elements including i
        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[n-1] - prefixSum[i];
            int leftTotal = (i*nums[i]) - leftSum;
            int rightTotal = rightSum - ((n-i-1)*nums[i]);
            res[i] = leftTotal + rightTotal;
        }

        return res;
    }
}
