class ExpandingWindow {
    public int longestConsecutive(int[] nums) {
        
        if (nums.length == 0) return 0;
        
        Set<Integer> set = new HashSet<>();
        for(Integer n: nums) {
            set.add(n);
        }
        
        int max = 0;
        for(int i=0; i<nums.length; i++) {
            int left = nums[i]-1;
            int right = nums[i]+1;
            
            while(set.remove(left)) left--;
            while(set.remove(right)) right++;
            
            max = Math.max(max,right-left-1);
        }
        
        return max;
    }
}
