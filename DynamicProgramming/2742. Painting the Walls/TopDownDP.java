/*
 * Learned:
 *   - Just getting my head around top-down DP.
 *   - DP usually has _choices_, or _options_. Here, we can have the paid painter paint, or not.
 *   - With top-down DP, you always want to cache outcomes, since the recursion forms a mirrored graph, with duplicated calculations.
 *   - I struggled to understand, and would not have come up with, the second base case, where i == n (infinite cost to the job).
 *   - Use of (int) 1e9 to express a large number, avoiding Integer.MAX_VALUE since it's right at the overflow limit.
 */
class TopDownDP {
    int n;
    int[][] memo;

    public int paintWalls(int[] cost, int[] time) {
        // BottomUpDP
        // start from base cases: (i == n, remain <= 0), and build up to answer

        // Top-Down

        // while paid is occupied on i, free guy paints time[i] walls
        // we spent cost[i] to paint i (paid) + time[i] (free) walls
        // paint n total walls, keeping cost to minimum

        // define the top-down recursive function
        // goDeeper(i, remain) where _remain_ is the walls, and _i_ is the index
        // base case: remain <= 0, all walls painted. Return 0
        // base case: i == n, we've run out of walls to put paid painter on, and task is impossible
            // i.e there are still more walls, but we don't have access to them?? or something
        
        // two choices: paid painter paints, or doesn't paint
        //   - if he paints, the cost is: cost[i] + goDeeper(i+1, remain - 1 - time[i])
        //   - if he skips, the cost is: goDeeper(i+1, remain)
        
        // thus, we want the minimum cost between these two options, each time:
        // goDeeper(i, remain) = min(paints, skips)

        // each goDeeper creates two more goDeeper (one for each option), so we must cache.
        this.n = cost.length;
        this.memo = new int[cost.length][cost.length+1];
        return dp(0, cost.length, cost, time);
    }

    private int dp(int i, int remain, int[] cost, int[] time) {
        if (remain <= 0) {
            return 0; // no more walls, no more cost
        } 
        
        if (i == n) { // no more options, but more walls, impossible to paint w/o options
            return (int) 1e9; // need large value, but Integer.MAX_VALUE overflows
        }

        if (memo[i][remain] != 0) { // cache hit
            return memo[i][remain];
        }

        int costToPaint = cost[i] + dp(i+1, remain - 1 - time[i], cost, time);
        int costToSkip = dp(i+1, remain, cost, time);
        memo[i][remain] = Math.min(costToPaint, costToSkip);
        return memo[i][remain];
    }
}
