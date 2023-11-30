/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class IterativeDFS {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // DFS the two roots, and at each leaft, ensure they're the same
        // break any time they're not
        List<Integer> leaves1 = getLeaves(root1);
        List<Integer> leaves2 = getLeaves(root2);
        if (leaves1.size() != leaves2.size()) return false;
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> getLeaves(TreeNode node) {
        Deque<TreeNode> deq = new ArrayDeque<>();
        TreeNode curr = node;
        List<Integer> leaves = new ArrayList<>();
        while (curr != null || !deq.isEmpty()) {
            if (curr != null) {
                deq.addFirst(curr);
                curr = curr.left; // go left
            } else {
                // pop first and try right: i.e. left then right, "in order traversal"
                curr = deq.removeFirst();
                if (curr.left == null && curr.right == null) {
                    leaves.add(curr.val);
                }
                curr = curr.right; // go right
            }
        }
        return leaves;
    }
}
