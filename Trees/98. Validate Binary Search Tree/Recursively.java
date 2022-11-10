class Recursively {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    private boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) return true;
        if (low != null && root.val <= low) return false;
        if (high != null && root.val >= high) return false;
        
        boolean left = validate(root.left, low, root.val);
        boolean right = validate(root.right, root.val, high);
        
        return left && right;       
    }
}
