class Solution {
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != 0) {
                slow++;
                fast++;
                continue;
            }
            if (nums[fast] == 0) {
                fast++;
                continue;
            }

            nums[slow] = nums[fast];
            nums[fast] = 0;
        }
    }
}
