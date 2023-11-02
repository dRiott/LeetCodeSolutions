/**
 * Learned:
 *   - Hey, read the problem correctly.
 *   - For the base case with recursion, consider null nodes, not the node _before_ null nodes
 *   - Original answer did double the recursive work, since it did that call for every node.
 *
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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        recurse(root);
        return count;
    }

    // int[0] == count, int[1] == sum
    public int[] recurse(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] res = new int[]{1,node.val};
        
        
        int[] l = recurse(node.left);
        res[0]+=l[0];
        res[1]+=l[1];

        int[] r = recurse(node.right);
        res[0]+=r[0];
        res[1]+=r[1];


        if (node.val == res[1] / res[0]) {
            this.count++;
        }
        return res;
    }
}
