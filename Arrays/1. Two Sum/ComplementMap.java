class ComplementMap {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> comp = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer match = comp.get(target-nums[i]);
            if (match != null) {
                int[] result = {match, i};
                return result;
            }
            comp.put(nums[i], i);
        }
        return new int[0];
    }
}
