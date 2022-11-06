class CheckingHashSet {
    public int longestConsecutive(int[] nums) {
        if (nums.length <=1) return nums.length;

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 1;
        for (int i = 0; i < nums.length; i++) {
          if (set.contains(nums[i]-1)) continue; // skip, part of other sequence
          
          int val = nums[i];
          int count = 1;
          while (set.contains(++val)) {
            count++;
          }
          max = Math.max(max, count);
        }

        return max;
    }
}
