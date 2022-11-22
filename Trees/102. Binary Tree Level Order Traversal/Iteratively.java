class Iteratively {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
      
        Deque<TreeNode> q = new ArrayDeque<>();
        if (root != null) q.addLast(root);

        while (!q.isEmpty()) {
          
            // bound how many nodes to pull before level end
            for (int i = 0; i < q.size(); i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) q.addLast(node.left);
                if (node.right != null) q.addLast(node.right);
            }

            res.add(level); // finish previous level
            level = new ArrayList<>(); // start new level            
        }

        return res;
    }
}
