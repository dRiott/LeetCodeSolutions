class MaxHeap {
    public int constrainedSubsetSum(int[] nums, int k) {
        // What is a subsequence? Removing any number of elements (or none) from the array, you can obtain a new array.
        // However, in removing numbers, we cannot create a "gap" of k or more
        // We would like to take all the positive numbers while avoiding the negative numbers

        // dp[i] represent the maximum possible sum of a subsequence that includes and ends at nums[i]
        // dp would take too long?

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> b[0] - a[0]); // default constructor is min
        // heap: offer/peak/poll; add/remove; clear

        // [max value, index]
        heap.offer(new int[]{nums[0], 0});
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // max values from previous indices may be too far in the past; i.e. have too big of a "gap"
            // throw these previous max candidates out
            while (i - heap.peek()[1] > k) {
                heap.poll();
            }

            int curr = Math.max(0, heap.peek()[0]) + nums[i]; // new candidate: previous dp max (at top of heap), plus i'th value
            res = Math.max(res, curr); // need to keep a running res for cases with only negative numbers and initial indices thrown out of heap
            heap.offer(new int[]{curr, i});
        }

        return res;
    }
}
