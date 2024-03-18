class SinglePass {
    // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    // Sort them in-place so that objects of the same color are adjacent in order, 0s, then 1s, then 2s.
    // The problem is known as Dutch National Flag Problem and first was proposed by Edsger W. Dijkstra.
    // https://en.wikipedia.org/wiki/Dutch_national_flag_problem
    public void sortColors(int[] nums) {

        // three pointers: right boundary of zero, left boundary of twos
        // curr pointer is used to iterate through and swap with left or right boundaries
        int rightZero = 0, leftTwo = nums.length-1, curr = 0;
        
        while (curr <= leftTwo) {
            if (nums[curr] == 0) {
                swap(nums, curr++, rightZero++);
            } else if (nums[curr] == 2) {
                swap(nums, curr++, leftTwo--);
            } else {
                curr++;
            }
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
}
