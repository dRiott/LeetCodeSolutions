class FindOffsetThenSearch {
    public int search(int[] nums, int target) {
        int offset = 0, len = nums.length;
        int min = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] < min) {
                offset = i;
                break;
            }
            min = nums[i];
        }

        int left = 0, right = len -1;
        while (left<=right) {
            int mid = left + (right-left)/2;
            int index = (mid+offset)%len;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] > target) {
                right = mid - 1;
            } else {
                left = mid+1;
            }
        }

        return -1;
    }
}
