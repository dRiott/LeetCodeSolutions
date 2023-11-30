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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        // DFS the two roots, and at each leaft, ensure they're the same
        // break any time they're not
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);
        
        if (leaves1.size() != leaves2.size()) return false;
        for (int i = 0; i < leaves1.size(); i++) {
            if (leaves1.get(i) != leaves2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeaves(TreeNode node, List<Integer> leaves) {
        if (node != null) {
            if (node.right == null && node.left == null) {
                leaves.add(node.val);
            }
            getLeaves(node.left, leaves);
            getLeaves(node.right, leaves);
        }
    }
}
