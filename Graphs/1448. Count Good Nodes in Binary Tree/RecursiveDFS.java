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
class RecursiveDFS {
    int count;
    public int goodNodes(TreeNode root) {
        // as you traverse, bring along the max
        // if ever the node value is > max, count+1, set new max

        count = 0;
        dfs(root, Integer.MIN_VALUE);
        return count;
    }

    private void dfs(TreeNode curr, int max) {
        if (curr != null) {
            if (curr.val >= max) {
                this.count++;
            }
            dfs(curr.left, Math.max(max, curr.val));
            dfs(curr.right, Math.max(max, curr.val));
        }
    }
}
