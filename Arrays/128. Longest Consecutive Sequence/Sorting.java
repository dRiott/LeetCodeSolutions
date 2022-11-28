class Sorting {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;

        Arrays.sort(nums);

        int max = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] == nums[i]) continue;
            if (nums[i-1] + 1 == nums[i]) {
                count++;
                max = Math.max(max, count);
            } else {
                count = 1;
            }
        }
        return max;
    }
}
