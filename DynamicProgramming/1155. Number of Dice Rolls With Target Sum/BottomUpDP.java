// start with a brute-force solution and then optimize it
class BottomUpDP {
    private static final int MOD = (int) 1e9 + 7;
    
    public int numRollsToTarget(int n, int k, int target) {
        // factors of target, max of k
        
        int[][] cache = new int[n+1][target+1];

        cache[n][target] = 1;

        for (int dice = n-1; dice >=0; dice--) { // for each dice

            for (int currSum = 0; currSum <= target; currSum++) { // each possible intermediate state (sum)
                int ways = 0;
                for (int i = 1; i <= Math.min(k, target-currSum); i++) {

                    ways = (ways + cache[dice+1][currSum+i]) % MOD;
                }
                cache[dice][currSum] = ways;
            }

        }
        return cache[0][0];
    }

}
