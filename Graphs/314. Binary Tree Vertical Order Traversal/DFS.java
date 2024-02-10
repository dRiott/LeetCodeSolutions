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
class DFS {
    private Integer min = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        Map<Integer, List<Pair<Integer, Integer>>> g = new HashMap<>();

        dfs(g, root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        while (g.get(min) != null) {
            List<Pair<Integer, Integer>> values = g.get(min);
            Collections.sort(values, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
                }
            });
            List<Integer> sortedColumn = new ArrayList();
            for (Pair<Integer, Integer> p : values) {
                sortedColumn.add(p.getValue());
            }
            res.add(sortedColumn);
            min++;
        }

        return res;
    }

    private void dfs(Map<Integer, List<Pair<Integer, Integer>>> g, TreeNode n, int col, int row) {
        if (n != null) {
            this.min = Math.min(this.min, col);
            List<Pair<Integer, Integer>> s = g.getOrDefault(col, new ArrayList<>());
            s.add(new Pair(row, n.val));
            g.put(col, s);
            dfs(g, n.left, col-1, row+1);
            dfs(g, n.right, col+1, row+1);
        }
    }
}
