class Solution {
    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> cache = new HashMap<>();
        
        Map<Integer, Integer> pt = new HashMap<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int points = pt.getOrDefault(nums[i], 0);
            pt.put(nums[i], points += nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        return dp(maxVal, pt, cache);   
    }
    
    private int dp(int val, Map<Integer, Integer> pt, Map<Integer, Integer> cache) {
        
        // base cases:
        if (val == 0) return 0;
        if (val == 1) return pt.getOrDefault(1, 0);
        if (cache.get(val) != null) return cache.get(val);
        
        int skip = dp(val-1, pt, cache);
        int take = dp(val-2, pt, cache) + pt.getOrDefault(val,0);
        cache.put(val, Math.max(take, skip));
        return cache.get(val);
    }
}
