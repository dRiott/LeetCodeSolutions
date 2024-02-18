class Solution {
    public int deleteAndEarn(int[] nums) {
        
        Map<Integer, Integer> pt = new HashMap<>();
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int points = pt.getOrDefault(nums[i], 0);
            pt.put(nums[i], points += nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
        }
        
        int[] max = new int[maxVal+1];
        max[0] = 0;
        max[1] = pt.getOrDefault(1,0);
        
        for (int i = 2; i <= maxVal; i++) {
            int skip = max[i-1]; // no gain, just keep previous points
            int take = max[i-2] + pt.getOrDefault(i, 0); // take, deleting i-1 (and i+1, which is 0)
            max[i] = Math.max(skip, take);
        }
        
        return max[maxVal];
}
