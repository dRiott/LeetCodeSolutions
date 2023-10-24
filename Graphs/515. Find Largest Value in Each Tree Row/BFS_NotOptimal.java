/**
 * Learned:
 *   - While my approach here works, it's a weird one, and uses an unnecessary Set<TreeNode> seen
 *   - Instead, remember proper BFS uses the while(!queue.isEmpty()), but then **a for loop** for the queue length to iterate the row.
 *   
 * 
 * --------------
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
class BFS_NotOptimal {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) return Collections.emptyList();
        // BFS
        // max for the level
        // keep track of the right-most element in the queue
        // if you've seen the right-most, add to res, set new right-most to last in queue

        List<Integer> res = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        Deque<TreeNode> bfs = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        bfs.add(root);
        seen.add(root);

        while (!bfs.isEmpty()) {
            TreeNode node = bfs.remove();
            max = Math.max(max, node.val);
            
            if (node.left != null) bfs.add(node.left);
            if (node.right != null) bfs.add(node.right);
            
            if (seen.contains(node)) {
                res.add(max);
                max = Integer.MIN_VALUE;

                // find right-most node
                seen.add(bfs.peekLast());
            } 
        }

        return res;
    }
}
