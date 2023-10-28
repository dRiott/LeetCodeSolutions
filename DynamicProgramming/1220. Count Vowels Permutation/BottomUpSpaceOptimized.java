/**
 * Learned:
 *   - You had the DP approach, but at first tried a single-dimension array.
 *   - Turns out, that'll work! Remember though, you need to calculate the next value before
 *   - assigning anything, or it messes up the counts mid-calculation.
 */
class Solution {
    private static int MOD = (int)1e9 +7;

    // If we picture strings that end with different vowels as different states,
    // what we have acquired is actually a map of all possible state transitions.
    public int countVowelPermutation(int n) {
        
        
        // strings of length [i] which end in vowel [j]
        long[] dp = new long[5];
        
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp,1);
        }

        // a == 0, e == 1, i == 2, o == 3, u == 4
        for (int i = 1; i < n; i++) {
            long aCount = (dp[1] + dp[2] + dp[4]) % MOD; // e, i, u (1,2,4) --> a
            long eCount = (dp[0] + dp[2]) % MOD; // a, i (0,2) --> e
            long iCount = (dp[1] + dp[3]) % MOD; //e, o (1,3) --> i
            long oCount = dp[2] % MOD; // i (2) --> o
            long uCount = (dp[2] + dp[3]) % MOD; // i, o (2,3) --> u
            dp[0] = aCount;
            dp[1] = eCount;
            dp[2] = iCount;
            dp[3] = oCount;
            dp[4] = uCount;
        }

        long res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = (res + dp[i]) % MOD;
        }
        return (int) res % MOD;
    }    
}
