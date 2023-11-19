class SortAndCount {
    public int reductionOperations(int[] nums) {
        // first encountered i of largest value
        // make the largest one equal to the value of the next largest
        // count operations

        // how many steps are there?
        // each element as a step in ladder
        // count nums between each val
        if (nums.length == 0) return -1;

        Arrays.sort(nums);
        int level = 0;
        int prev = nums[0];
        int op = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev) {
                prev = nums[i];
                level++;
            }
            op += level;
        }
        return op;
    }
}
