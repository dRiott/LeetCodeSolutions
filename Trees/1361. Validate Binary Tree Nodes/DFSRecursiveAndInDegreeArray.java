/* 
 * Learned:
 *   - To increment the value in an array, use pre- or post-increment: ++array[i] or array[i]++
 *   - Idea here is to use an "inDegree" array, which is the count (value) of nodes (index). This
 *       This allows you to check for circularity, as well as easily identify the root.
 *   - Reminder: DFS recursive checks left and right side outcomes and returns a result
 */
class DFSRecursiveAndInDegreeArray {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];
        

        // Pass through both arrays, failing if more than one of each number (child) exists
        // i.e. if inDegree of any node > 1, return false
        for (final int child : leftChild)
        if (child != -1 && inDegree[child]++ == 2)
            return false;

        for (final int child : rightChild)
        if (child != -1 && inDegree[child]++ == 2)
            return false;

        // find root
        int root = -1;
        for (int r = 0; r < n; r++) {
            if (inDegree[r] == 0) { // because root won't be present, it's count is 0
                if (root == -1) {
                    root = r;
                } else {
                    // if we've already set a root, we found two roots --> invalid: false
                    return false;
                }
            }
        }

        if (root == -1) return false;

        // DFS recursively, with visited array to ensure all nodes visited (tree is connected)
        boolean[] visited = new boolean[n];
        if (!dfs(root, leftChild, rightChild, visited)) return false;

        // ensure all nodes visited (tree is connected);
        for(boolean v: visited) {
            if (!v) {
                 return false;
            }
        }

        return true;
    }

    private boolean dfs(int node, int[] left, int[] right, boolean[] visited) {
        if (visited[node]) return false;

        visited[node] = true;
        int l = left[node], r = right[node];
        if (l != -1) {
            if (!dfs(l, left, right, visited)) return false;
        }
        if (r != -1) {
            if (!dfs(r, left, right, visited)) return false;
        }
        return true;
    }
}
