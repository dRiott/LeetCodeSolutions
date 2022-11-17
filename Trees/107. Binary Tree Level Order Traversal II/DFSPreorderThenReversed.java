class DFSPreorderThenReversed {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        helper(res, root, 0);
        Collections.reverse(res); // lame, but the diff between LC problems I and II
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int level) {
        if (res.size() == level) res.add(new ArrayList<>()); // start level
        res.get(level).add(node.val);
        
        
        if (node.left != null) helper(res, node.left, level+1);
        if (node.right != null) helper(res, node.right, level+1);
    }
}
