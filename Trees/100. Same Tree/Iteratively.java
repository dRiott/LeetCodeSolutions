class Iteratively {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        Deque<TreeNode> qp = new ArrayDeque<>();
        Deque<TreeNode> qq = new ArrayDeque<>();
        
        if (p != null) qp.add(p);
        if (q != null) qq.add(q);

        while (!qp.isEmpty()) {

            if (qq.isEmpty()) return false;
            TreeNode pNode = qp.removeFirst();
            TreeNode qNode = qq.removeFirst();

            if (pNode.val != qNode.val) return false;
            

            if (pNode.left != null) {
                if (qNode.left == null) return false;
                qp.addLast(pNode.left);
                qq.addLast(qNode.left);
            } else if (qNode.left != null) {
                return false;
            }
            if (pNode.right != null) {
                if (qNode.right == null) return false;
                qp.addLast(pNode.right);
                qq.addLast(qNode.right);
            } else if (qNode.right != null) {
                return false;
            }
        }

        return qq.isEmpty();
    }
}
