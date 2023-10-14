class BottomUpDP {

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        int[][] dp = new int[n + 1][n + 1];

        // cost to paint n walls with only n-1 options available is an impossible cost
        // no matter the number of options (i), we cannot paint n walls; impossible cost
        for (int i = 1; i <= n; i++) {
            dp[n][i] = (int) 1e9; 
        }

        for (int i = n - 1; i >= 0; i--) { // progressively expose more options in costs/times
            for (int wallsRemaining = 1; wallsRemaining <= n; wallsRemaining++) {
                int previousCost = dp[i+1][Math.max(0, wallsRemaining - 1 - time[i])];
                int costToPaint = cost[i] + previousCost;
                int costToSkip = dp[i+1][wallsRemaining];
                dp[i][wallsRemaining] = Math.min(costToPaint, costToSkip);
            }
        }

         // where when i == 0, all costs/times options considered
         // and we've painted all (n, 1-indexed) walls
        return dp[0][n];
    }
}
