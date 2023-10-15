/*
 * Learned:
 *   - The DP memoization function is typically a multi-dimension array
 *       where the lengths are max values of dp function parameters
 * Remember:
 *   - DP: you have choices, and past behavior
 *   - Choices: right, left, stay
 *   - For each choice, curr changes (or stays), and steps decrements
 *   - Return value for DP function is always the goal of problem
 *   - Here, goal is dp(curr,steps): increment when curr = 0
 */
class TopDownDP {

    private static int MOD = (int) 1e9 + 7;
    int maxDistance;
    int[][] memo;

    public int numWays(int steps, int arrLen) {
        // Larger values of arrLen (greater than steps) are pointless
        // because we could not reach those states due to running out of steps 
        maxDistance = Math.min(steps, arrLen);

        // initialize memo array with -1 as possible moves, uncalculated
        memo = new int[maxDistance][steps+1];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(0, steps);
    }

    private int dp(int curr, int remain) {
        if (remain == 0) {
            return curr == 0 ? 1 : 0;
        }

        int dpCacheResult = memo[curr][remain];
        if (dpCacheResult != -1) {
            return dpCacheResult;
        }

        // result from staying
        int res = dp(curr, remain-1);
        
        // plus result from attempting to going right
        if (curr < maxDistance-1) {
            res = (res + dp(curr + 1, remain-1)) % MOD;
        }
        
        // plus result from attempting to going right
        if (curr > 0) {
            res = (res + dp(curr - 1, remain - 1)) % MOD;
        }

        memo[curr][remain] = res;

        return res;
    }
}
