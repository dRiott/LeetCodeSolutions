class ReverseOneSideAndCompare {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return sameTree(reverse(root.left), root.right);
    }

    public TreeNode reverse(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.addLast(root);

        while (!q.isEmpty()) {
            TreeNode node = q.removeFirst();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) q.addLast(node.left);
            if (node.right != null) q.addLast(node.right);
        }
        return root;
    }

    private boolean sameTree(TreeNode one, TreeNode two) {
        if (one == null && two == null) return true;
        if (one == null || two == null) return false;
        if (one.val != two.val) return false;

        return sameTree(one.left, two.left) && sameTree(one.right, two.right);
    }
}
