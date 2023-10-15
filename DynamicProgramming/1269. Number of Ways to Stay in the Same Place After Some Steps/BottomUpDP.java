/*
 * Learned:
 *   - With Bottom Up DP, it really matters which way you iterate.
 *       You must ensure the inner loop starts at the end of the first dp[x][] array (x).
 *       And the outer loop, the one first declared, goes up through the second, dp[][x].
 *   - Another way to think about iteration:
 *       - Start from the base case: our first loop begins with remaining steps == 1.
 *       - Generally, you want the final loop iteration to calculate the final answer.
 *       - For this problem, last is all steps, with curr at 0, so to return dp[0][steps].
 * Remember:
 *   - Bottom Up DP: the array replaces the recursive function
 */
class BottomUpDP {

    private static int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        
        int maxDistance = Math.min(steps, arrLen);

        // Initialize dp array with 0, as default case, where 0 solutions possible
        // Exception is the one solution we know, when curr==0, remain == 0 --> 1 possibility
        int[][] dp = new int[maxDistance][steps+1];
        dp[0][0] = 1;

        // Warning: don't flip the looping structure - final loop should calc final answer!
        // for (int curr = 0; curr < maxDistance; curr++) {
        //     for (int remain = steps; remain >= 1; remain--) {
        
        for (int remain = 1; remain <= steps; remain++) {
            for (int curr = maxDistance - 1; curr >= 0; curr--) {        
                // sum all options: stay, left, right 
                int sum = dp[curr][remain-1]; // consuming one step, but staying 
                
                if (curr+1 < maxDistance) {
                    sum = (sum + dp[curr+1][remain-1]) % MOD;
                }
                
                if (curr-1 >= 0) {
                    sum = (sum + dp[curr-1][remain-1]) % MOD;
                }

                dp[curr][remain] = sum;
            }
        }

        return dp[0][steps]; // return answer for _all_ steps, with curr at 0
    }
}
