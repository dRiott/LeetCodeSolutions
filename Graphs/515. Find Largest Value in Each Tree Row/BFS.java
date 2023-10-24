/**
 * Learned:
 *   - Reminder: Proper BFS uses a queue and an inner for loop for the row's length
 *
 * ---------------
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
class BFS {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();

        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);

        while (!bfs.isEmpty()) {
            int queueLen = bfs.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < queueLen; i++) {
                TreeNode node = bfs.remove();
                max = Math.max(max, node.val);

                if (node.left != null) bfs.add(node.left);
                if (node.right != null) bfs.add(node.right);
            }
            res.add(max);
        }

        return res;
    }
}
