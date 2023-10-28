/**
 * Learned:
 *   - You had the DP approach, but at first tried a single-dimension array.
 *   - A 2d array is required: first dimension for string length n, second for each vowel
 *   - In DP, sometimes it's useful to think about the reverse order of operations:
 *   -   here, if a vowel is **the last one in a string**, calculate permutations to get to it
 *   - Hence, the vowel mapping given in the problem should be reversed.
 *   - i.e. What are valid vowels that allow a step to me, a given vowel?
 *   - In Java, even for return type int with mod, you may need to use long to avoid overflow.
 */
class BottomUp {
    private static int MOD = (int)1e9 +7;

    // If we picture strings that end with different vowels as different states,
    // what we have acquired is actually a map of all possible state transitions.
    public int countVowelPermutation(int n) {
        
        
        // strings of length [i] which end in vowel [j]
        long[][] dp = new long[n][5];
        
        for (int i = 0; i < 1; i++) {
            long[] row = dp[i];
            Arrays.fill(row,1);
        }

        // a == 0, e == 1, i == 2, o == 3, u == 4
        for (int i = 1; i < n; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][2] + dp[i-1][4]) % MOD; // e, i, u (1,2,4) --> a
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD; // a, i (0,2) --> e
            dp[i][2] = (dp[i-1][1] + dp[i-1][3]) % MOD; //e, o (1,3) --> i
            dp[i][3] = (dp[i-1][2]) % MOD; // i (2) --> o
            dp[i][4] = (dp[i-1][2] + dp[i-1][3]) % MOD; // i, o (2,3) --> u
        }

        long res = 0;
        long[] nthRow = dp[n-1];
        for (int i = 0; i < nthRow.length; i++) {
            res = (res + nthRow[i]) % MOD;
        }
        return (int) res % MOD;
    }    
}
