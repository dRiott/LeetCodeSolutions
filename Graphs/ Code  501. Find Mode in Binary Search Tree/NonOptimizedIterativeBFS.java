/**
 * Learned:
 *   - Although BFS usually uses a Queue, here I'm using a Deque.
 *   - Remember, BFS visits them in level-order, hence adding node left and right immediately
 *   - Deque's _add_ method is equivalent to _addLast_.
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
class NonOptimizedIterativeBFS {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> val = new HashMap<>();

        Deque<TreeNode> s = new ArrayDeque<>();
        s.addFirst(root);
        while (!s.isEmpty()) {
            TreeNode node = s.removeFirst();
            val.put(node.val, val.getOrDefault(node.val, 0)+1);
            if (node.left != null) s.add(node.left);
            if (node.right != null) s.add(node.right);
        }

        int max = Integer.MIN_VALUE;
        for (Integer v : val.keySet()) {
            max = Math.max(max, val.get(v));
        }

        List<Integer> res = new ArrayList<>();
        for (Integer v : val.keySet()) {
            if (max == val.get(v)) {
                res.add(v);
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (int) res.get(i);
        }
        return ans;
    }
}
