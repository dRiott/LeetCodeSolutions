class LeftRightMultiples {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
             
        // [2, 4, 6, 8]
        // left = [2, 8, 48, 384]
        // right = [384, 192, 48, 8]

        // left[i-1] * right[i+1]

        int[] left = new int[len];
        int[] right = new int[len];

        int j = len - 1 ;
        for (int i = 0; i < len; i++) { 
            left[i] = (i == 0 ? 1 : left[i-1]) * nums[i];
            right[j] = (j == len-1 ? 1 : right[j+1]) * nums[j];
            j--;
        }

        for (int i = 0; i < len; i++) {
            int l = (i == 0 ? 1 : left[i-1]);
            int r = (i == len-1 ? 1 : right[i+1]);
            ans[i] = l*r;
        }

        return ans;
    }
}
