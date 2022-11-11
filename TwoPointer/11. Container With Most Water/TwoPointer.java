class TwoPointer {
    public int maxArea(int[] nums) {
        int max = 0;
        int left = 0, right = nums.length -1;

        while (left < right) {
            max = Math.max(max, (right-left)*Math.min(nums[left], nums[right]));
            if (nums[left] < nums[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
