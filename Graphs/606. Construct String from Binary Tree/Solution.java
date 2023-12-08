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
    public String tree2str(TreeNode root) {
        if (root == null) return "";
        
        // dfs pre-order
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        sb.append(node.val);
        if (node.left != null) {
            sb.append("(");
            dfs(node.left, sb);
            sb.append(")");
        }
        if (node.left == null && node.right != null) {
          sb.append("()");
        }
        if (node.right != null) {
            sb.append("(");
            dfs(node.right, sb);
            sb.append(")");
        }
    }
}
