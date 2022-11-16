class BooleanHelper {

    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root, p, q);
        return result;
    }

    private boolean lca(TreeNode node, TreeNode p, TreeNode q) {
        
        if (node == null) return false;

        boolean left = lca(node.left, p, q);
        boolean right = lca(node.right, p, q);
        boolean self = node.equals(p) || node.equals(q);

        if ((left && right) || (left && self) || (right && self)) {
            result = node;
        }

        return left || right || self;
    }
}
