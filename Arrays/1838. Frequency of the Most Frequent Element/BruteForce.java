class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int j = nums.length;
        
        int max = 1;
        while(--j >= 0) {
            int val = nums[j];

            // bring other numbers up to val
            int i = j;
            int count = 1;
            int kRound = k;
            while (kRound > 0 && --i >= 0) {
                int diff = val - nums[i];
                kRound -= diff;
                if (kRound >= 0) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }
}
