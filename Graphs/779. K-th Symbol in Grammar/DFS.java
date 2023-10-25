/*
 * Learned:
 *   - I did not intuit this problem as a graph
 *   - Instead I was closer to a recursive, value flipping solution
 *   - To think of it as a graph:
 *     - Your target is the kth leaf, at the lowest level
 *     - To step down towards k, you must descend left or right, so you need to decide which side k will be on, and go that way
 *     - Although we decrease n, think of it as moving deeper into the graph, not up towards the original root
 *     - In the base case, k is the root of a graph with size n==1
 */
class Solution {
    public int kthGrammar(int n, int k) {

        // find the pattern??
        // 1: 0
        // 2: 01
        // 3: 01 10
        // 4: 0110 1001
        // 5: 0110 1001 1001 0110

        // 2^29 ~500M, int stores ~2 trillion

        //int len = Math.pow(2, n-1); // also the number of nodes in the nth row of a perfect binary tree...
        
        // binary tree with binary search for the kth leaf
        return depthFirstSearch(n, k, 0);


        /*
        // brute force, declare or precompute them
        if (n == 1 && k == 1) {
            return 0;
        }

        int curr = 2;
        StringBuilder sb = new StringBuilder("01");
        StringBuilder r = new StringBuilder();
        while (curr++ < n) {
            if (curr % 2 == 1) {
                r.setLength(0);
                String mirror = r.append(sb.toString()).reverse().toString();
                sb.append(mirror);
            } else {
                char[] s = new char[sb.length()];
                sb.getChars(0, sb.length(), s, 0);

                for (char c : s) {
                    sb.append(c == '1' ? '0' : '1');
                }
            }
        }

        return sb.toString().charAt(k-1) - '0';
        */
    }
    
    // starting with n == 6, k == 21:
    // totalNodes == 32, since 2^(6-1) == 32
    // since k > (len/2), k is on the right half of the tree. Right half means the rootNode's value changes and so does k
    // k-(len/2) == newK, the position of k is: 21-16 == 5. So in 16 nodes, k is now the 5th, and our root changed from 0 to 1
    // when going left, however, k stays the same and so does the root.
    public int depthFirstSearch(int n, int k, int rootVal) {
        if (n == 1) {
            return rootVal;
        }

        int totalNodes = (int) Math.pow(2, n - 1);

        // Target node will be present in the right half sub-tree of the current root node.
        if (k > (totalNodes / 2)) {
            int nextRootVal = (rootVal == 0) ? 1 : 0;
            return depthFirstSearch(n - 1, k - (totalNodes / 2), nextRootVal);
        }
        // Otherwise, the target node is in the left sub-tree of the current root node.
        else {
            // any time you're decreasing a level, and the k is in the left half, the rootVal stays the same!
            // k stays the same
            int nextRootVal = (rootVal == 0) ? 0 : 1;
            return depthFirstSearch(n - 1, k, nextRootVal);
        }
    }
}
