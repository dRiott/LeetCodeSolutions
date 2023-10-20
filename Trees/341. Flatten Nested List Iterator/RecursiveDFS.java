/**
 * Learned:
 *   - Reminder: Iterative BFS uses a Stack.
 *   - Apparently it's easier for your to do DFS recursively.
 *
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class RecursiveDFS implements Iterator<Integer> {

    Queue<Integer> flattened = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger n : nestedList) {
            dfs(n);
        }
    }

    private void dfs(NestedInteger n) {
        if (n.isInteger()) {
            flattened.add(n.getInteger());
        } else {
            for (NestedInteger n2 : n.getList()) {
                dfs(n2);
            }
        }
    }

    @Override
    public Integer next() {
        return flattened.remove();
    }

    @Override
    public boolean hasNext() {
        return !flattened.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
