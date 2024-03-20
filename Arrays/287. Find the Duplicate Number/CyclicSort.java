class CyclicSort {
    /*
        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
        There is only one repeated number in nums, return this repeated number.
        You must solve the problem without modifying the array nums and uses only constant extra space.
     */
    public int findDuplicate(int[] nums) {

        // Cyclic sort
        
        // since the length of nums is one larger than it's largest value
        // we can deduce there's an "extra cell", and take it to be the first one, nums[0]
        // using this extra cell, we swap numbers into their place, where their val == their index
        // comparing nums[0] to the number at the position of it's value->index... nums[nums[0]]
        // and swap nums[0] into the right spot... until you hit a dupe!

        while(nums[0] != nums[nums[0]]) {
            int temp = nums[nums[0]];
            nums[nums[0]] = nums[0];
            nums[0] = temp;
        }

        return nums[0];
    }
}
