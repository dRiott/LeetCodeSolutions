class Solution {
    public void nextPermutation(int[] nums) {
        // start from the back
        // find the first number that descends
        // find the next largest number, and swap them
        // sort the remainder of the array in place
        
        if (nums.length == 1) return;

        // find the "pivot" - i will stop at -1 for a non-ascending sorted array
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        // only do a swap if non-ascending sorted (e.g. 3,2,1 --> don't swap any, just sort entire array)
        if (i >= 0) {
            // find the index of the next largest number compared to nums[i] ("pivot")
            int nextLargestIdx = i+1;
            int pivot = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                if (nums[j] > pivot && nums[j] < nums[nextLargestIdx]) {
                    nextLargestIdx = j;
                }
            }

            // swap them
            int temp = nums[i]; 
            nums[i] = nums[nextLargestIdx];
            nums[nextLargestIdx] = temp;
        }

        Arrays.sort(nums, i+1, nums.length);
    }
}
