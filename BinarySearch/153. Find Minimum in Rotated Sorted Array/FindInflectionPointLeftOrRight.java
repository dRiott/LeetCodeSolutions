class FindInflectionPointLeftOrRight {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length-1;
        
        if (nums[0] < nums[right]) return nums[0];
        
        while (left <= right) {
            int mid = left + (right-left)/2;
            
            if (nums[mid] > nums[mid + 1]) { // inflection point one right
                return nums[mid + 1];
            }

            if (nums[mid - 1] > nums[mid]) { // inflection point one left
                return nums[mid];
            }

            if (nums[0] < nums[mid]) {
                // left side is sorted, so go right
                left = mid + 1;
            } else {
                // right side is sorted, so go left
                right = mid - 1;
            }
        }
        return Integer.MAX_VALUE; // unreachable for nums.length > 0
    }
}
