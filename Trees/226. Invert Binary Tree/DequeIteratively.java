class DequeIteratively {
   public TreeNode invertTree(TreeNode root) {
       if (root == null) return root;

       Deque<TreeNode> queue = new ArrayDeque<>();
       queue.add(root);

       while (!queue.isEmpty()) {
           TreeNode node = queue.removeLast();
           if (node.left != null) queue.add(node.left);
           if (node.right != null) queue.add(node.right);

           TreeNode temp = node.left;
           node.left = node.right;
           node.right = temp;
       }

       return root;
   }
   
}
