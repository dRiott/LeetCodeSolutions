/*
 * Learned:
 *   - I didn't intuit this one without the Editorial, tough one.
 *   - I had an off-by-one bug in my binary search implementation: right should be initialized to nums.length, not nums.length-1 
 *   - I implemented something very near to the solution, but still had an issue on some test cases, and never found it, unfortunately.
 *   - There are other implementations to this problem that I could learn! The Monotonic Stack approach is also used elsewhere.
 */
class BinarySearch {
    /*
     Let's say we take some number of elements from the right section, and the minimum is x.
     How many elements can we take from the left section without changing x as the minimum?
     We must only take elements from the left that are greater than or equal to x.
     
     This only works if the minimum element is in the right array; therefore, we need to run it twice!
     First, we do so for the array as is, then we reverse the entire array, and apply the same approach.
     
     Consider right[9,10] and left [11,11,11] (k=2) - this would fail the first apply, but succeed on the reverse.
     */
    public int maximumScore(int[] nums, int k) {
        int ans = solve(nums, k);
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
        
        return Math.max(ans, solve(nums, nums.length - k - 1));
    }
    
    public int solve(int[] nums, int k) {
        int n = nums.length;
        int left[] = new int[k];
        int currMin = Integer.MAX_VALUE;
        for (int i = k - 1; i >= 0; i--) {
            currMin = Math.min(currMin, nums[i]);
            left[i] = currMin;
        }
        
        List<Integer> right = new ArrayList();
        currMin = Integer.MAX_VALUE;
        for (int i = k; i < n; i++) {
            currMin = Math.min(currMin, nums[i]);
            right.add(currMin);
        }
        
        int ans = 0;
        for (int j = 0; j < right.size(); j++) {
            currMin = right.get(j);
            int i = binarySearch(left, currMin);
            int size = (k + j) - i + 1;
            ans = Math.max(ans, currMin * size);
        }

        return ans;
    }
    
    public int binarySearch(int[] nums, int num) {
        int left = 0;
        int right = nums.length;
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
}
