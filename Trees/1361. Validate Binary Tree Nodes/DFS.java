/* 
 * Learned:
 *   - Reminder: Binary Trees are valid if there is only one root (has no parents),
 *       and all children only have one parent (not circular).
 *   - Reminder: DFS interatively uses a stack, pushing and popping nodes until empty.
 *   - Reminder: BFS, on the other hand, uses the same approach but with a FIFO queue.
 */
class DFS {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // leftChild.length == n && rightChild.length == n
        
        // node 0 has 1, 2, node 1 has no children, node 2 has 3, node 3 has no children
        // leftChild = [1,-1,3,-1], rightChild = [2,-1,-1,-1]

        // binary tree is valid if: nodes have only one parent, and one root node (no parents)

        // the binary tree nodes are numbered, so I shouldn't have repeating values
        // basically failing for circular graphs
        
        // if different indices point to the same number --> two parents
        // all nodes in the tree

        int root = findRoot(n-1, leftChild, rightChild);
        if (root == -1) {
            return false;
        }

        // DFS starting with root
        
        int[] seen = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            
            if (seen[node] == 1) {
                // Already seen this node, indicating a cycle
                return false;
            } else {
                seen[node] = 1;
            }

            if (leftChild[node] != -1) {
                stack.push(leftChild[node]);
            }
            if (rightChild[node] != -1) {
                stack.push(rightChild[node]);
            }
        }


        // all nodes connected if we've seen them all with DFS
        int sumSeen = 0;
        for (int i = 0; i < seen.length; i++) {
            sumSeen+=seen[i];
        }
        return sumSeen == n;
    }

    private int findRoot(int maxNodeValue, int[] left, int[] right) {
        // create a set of values in leftChild and rightChild
        Set<Integer> s = new HashSet<>();
        for (int l : left) {
            s.add(l);
        }
        for (int r : right) {
            s.add(r);
        }

        for (int i = 0; i <= maxNodeValue; i++) {
            if (!s.contains(i)) { // root would not be present in left or right
                return i;
            }
        }

        return -1; // all numbers found in left and right, therefore no root
    }
}
