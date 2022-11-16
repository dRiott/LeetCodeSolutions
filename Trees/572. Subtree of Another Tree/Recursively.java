class Recursively {
    boolean isSubTree = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (sameTree(root, subRoot)) {
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return root == null && subRoot == null;
        }
        return root.val == subRoot.val && sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
    }
}
