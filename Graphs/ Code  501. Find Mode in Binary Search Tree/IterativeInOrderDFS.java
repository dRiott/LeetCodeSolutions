/**
 * Learned:
 *   - Iterative, in-order DFS is a bit tricky to work out, see below.
 *   - Sometimes it's easier to create the data structure you want (here, sorted list), then operate.
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
class IterativeInOrderDFS {
    public int[] findMode(TreeNode root) {

        // iterative in-order DFS
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode curr = root;
        List<Integer> inOrder = new ArrayList<>();
        while (!s.isEmpty() || curr != null) {
            if (curr != null) {
                s.addFirst(curr);
                curr = curr.left;
            } else {
                curr = s.removeFirst();
                inOrder.add(curr.val);
                curr = curr.right;
            }
        }
        
        List<Integer> ans = new ArrayList();

        int max = Integer.MIN_VALUE;
        int prev = 0;
        int count = 0;
        for (Integer val : inOrder) {
            if (val == prev) {
                count++;
            } else {
                count = 1;
                prev = val;
            }

            if (count > max) {
                max = count;
                ans = new ArrayList<>();
            }

            if (count == max) {
                ans.add(val);
            } 
            
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
