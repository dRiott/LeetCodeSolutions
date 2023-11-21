/**
 * Learned:
 *   - For problems with i and j on either side of an equation, rearrange it...
 *   - Intuition: nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) becomes
 *     nums[i] - rev(nums[i]) == nums[j] - rev(nums[j])
 *   - If we build an array with nums[i] - rev(nums[i]) values, the problem becomes
 *     "How many pairs in arr are equal?"
 *   - Factorial sum trick: as we build the count, we add existing count, then increment.
 */
class Solution {
    private static final int MOD = (int) 1e9 + 7;
    private static Map<Integer, Integer> cache;

    public int countNicePairs(int[] nums) {
        cache = new HashMap<>();

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] - reverse(nums[i]);
        }

        // how many pairs in are equal?
        // hashmap of value to count... using factorial sum trick
        int nicePairs = 0;
        for (int i = 0; i < res.length; i++) {
            int count = cache.getOrDefault(res[i], 0);
            nicePairs = (nicePairs + count) % MOD;
            cache.put(res[i], count+1);
        }

        return nicePairs;
    }

    private int reverse(int n) {
        if (n < 10) return n;
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }
}
