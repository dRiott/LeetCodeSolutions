class Recursively {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (q == null && p == null) return true;
        if (q == null || p == null) return false;

        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
