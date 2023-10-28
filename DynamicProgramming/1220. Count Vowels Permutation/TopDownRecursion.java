/**
 * Learned:
 *   - With recursive, top-down approach, it's always recursing backwards, e.g. n-1
 *   - Often, you're doing something to multiple paths, e.g. min/maxing them, or summing them: path1(n-1) + path2(n-1)
 *   - Remember that recursive implementations always eat up more memory than iterative ones.
 */
class TopDownRecursion {
    private static int MOD = (int)1e9 +7;
    private static long[][] memo;

    // If we picture strings that end with different vowels as different states,
    // what we have acquired is actually a map of all possible state transitions.
    public int countVowelPermutation(int n) {
        
        
        // strings of length [i] which end in vowel [j]
        long[] dp = new long[5];
        memo = new long[n][5];
        long res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = (res + dp(n-1, i)) % MOD;
        }
        return (int) res;
    }

    private long dp(int i, int vowel) {
        // a == 0, e == 1, i == 2, o == 3, u == 4
        
        if (memo[i][vowel] != 0) {
            return memo[i][vowel]; // cache hit
        }
        if (i == 0) {
            memo[i][vowel] = 1; // base case, string of one length, one answer
        } else {
            memo[i][0] = (dp(i-1, 1) + dp(i-1,2) + dp(i-1,4)) % MOD; // e, i, u (1,2,4) --> a
            memo[i][1] = (dp(i-1, 0) + dp(i-1,2)) % MOD;             // a, i (0,2) --> e
            memo[i][2] = (dp(i-1, 1) + dp(i-1,3)) % MOD;             // e, o (1,3) --> i
            memo[i][3] = dp(i-1, 2) % MOD;                           // i (2) --> o
            memo[i][4] = (dp(i-1, 2) + dp(i-1,3)) % MOD;             // i, o (2,3) --> u
        }

        return memo[i][vowel];
    }
}
