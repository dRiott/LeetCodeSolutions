/*
 * Learned:
 * - LeetCode confusion: "Run" reuse the same Solution object, keeping graph across all Test Cases! Instantiate in method to prevent this.
 * - Be careful about the directionality of the graph, as I go this "pre-requisite" relationship reversed
 */
class TopDownDP {
    
    // 
    private static Map<Integer,List<Integer>> graph;
    private static int[] memo;

    public int minimumTime(int n, int[][] relations, int[] time) {
        // "completing courses": relations[i] is len 2, [prev, next] --> pre-requisite relationship

        // building a graph from relations
        graph = new HashMap<>();
        for (int[] rel : relations) {
            int preReq = rel[0], next = rel[1];
            graph.computeIfAbsent(preReq, v -> new ArrayList<>()).add(next);
        }

        
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp(i, time));
        }

        return res;
    }

   
    private int dp(int c, int[] time) {
        if (memo[c] != -1) {
            return memo[c];
        }

        List<Integer> children = graph.get(c);
        if (children == null || children.isEmpty()) {
            return time[c-1];
        }

        int max = 0;
        for (Integer child : children) {
            max = Math.max(max, dp(child, time));
        }

        // maximum value of all children plus your own class time
        memo[c] = time[c-1] + max;
        return memo[c];
    }
}
