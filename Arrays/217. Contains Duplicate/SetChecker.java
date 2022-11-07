class SetChecker {
    public boolean containsDuplicate(int[] nums) {

        // keep a set, adding nums into set as you see them
        Set<Integer> seen = new HashSet<>(nums.length);
        
        for (int i = 0; i < nums.length; i++) {
            if (!seen.add(nums[i])) return true;
        }
        
        return false;
    }
}
