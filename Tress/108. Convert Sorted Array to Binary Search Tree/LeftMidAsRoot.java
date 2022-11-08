class LeftMidAsRoot {
    public TreeNode sortedArrayToBST(int[] nums) {
            return traverse(nums, 0, nums.length - 1);
    }

    private TreeNode traverse(int[] nums, int left, int right) {
        if (left > right) return null;

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = traverse(nums, left, mid - 1);
        root.right = traverse(nums, mid + 1, right);
        
        return root;
    }
}
