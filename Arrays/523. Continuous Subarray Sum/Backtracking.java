public class Backtracking {

    /*
    Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
    A good subarray is a subarray where:
      its length is at least two, and
      the sum of the elements of the subarray is a multiple of k.
     */
    public boolean checkSubarraySum(int[] nums, int k) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0 && nums[i - 1] == 0)
                return true;
        }

        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
            if (prefix[i] % k == 0) {
                return true;
            }
            
            int j = i - 2;

            // Attn: I missed this secondary condition, checking that the diff is GTE k
            // We prevent backtracking when we know there will never be a potential solution
            while ((j >= 0) && (prefix[i] - prefix[j] >= k)) {
                if ((prefix[i] - prefix[j]) % k == 0) {
                    return true;
                }
                j--;
            }
        }
        return false;
    }
}
