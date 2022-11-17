class Iteratively {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();

        // iteratively: 
        // fill up a queue, adding a spacer between levels
        // process the queue backwards, using spacer (-1001, since val [-1000, 1000]) to term lists

        Deque<TreeNode> queue = new ArrayDeque<>();
        Deque<TreeNode> perm = new ArrayDeque<>();
        
        // add terminal marker to ensure root is added to levels at final step
        perm.add(new TreeNode(-1001));
        if (root != null) {
            queue.addLast(root);
            perm.addLast(root);
        }
        perm.add(new TreeNode(-1001)); // mark the end of root's level

        while (!queue.isEmpty()) {
            int size = queue.size(); 
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                // right first, since we're processing reversed
                if (node.right != null) {
                    queue.add(node.right);
                    perm.add(node.right);
                }
                if (node.left != null) {
                    queue.add(node.left);
                    perm.add(node.left);
                }
            }
            
            if (!queue.isEmpty()) perm.add(new TreeNode(-1001)); // only when not empty prevents final one
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();

        if (!perm.isEmpty()) perm.removeLast(); // throw away the terminal marker

        while (!perm.isEmpty()) {
            TreeNode node = perm.removeLast();
            if (node.val == -1001) {
                res.add(level);
                level = new ArrayList<>();
            } else {
                level.add(node.val);
            }
        }
        return res;
    }
}
