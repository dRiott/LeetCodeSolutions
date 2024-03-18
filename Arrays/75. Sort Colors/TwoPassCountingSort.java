class Solution {
    // We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
    // Sort them in-place so that objects of the same color are adjacent in order, 0s, then 1s, then 2s.
    public void sortColors(int[] nums) {
        int countZero = 0;
        int countOne = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) countZero++;
            if (nums[i] == 1) countOne++;
        }

        for (int i = 0; i < nums.length; i++) {
            if (countZero > 0) {
                nums[i] = 0;
                countZero--;
                continue;
            }
            if (countOne > 0) {
                nums[i] = 1;
                countOne--;
                continue;
            }
            nums[i] = 2;
        }
    }
}
