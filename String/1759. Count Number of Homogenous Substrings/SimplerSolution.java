/**
 * Learned:
 *   - Compared with the previous "Solution.java", this one adds _count_ each iteration,
 *     which achieves the same thing as factorialSum whne the streak changes, but without factorialSum iterations.
 */ 
class Solution {
    private final int MOD = (int) 1e9 + 7;
    public int countHomogenous(String s) {
        
        char[] l = s.toCharArray();
        if (l.length == 0) return 0;

        char p = l[0];
        int count = 1;
        int sum = 1; // start with 1 from the first p
        for (int i = 1; i < l.length; i++) {
            if (l[i] != p) {
                count = 1;
                p = l[i];
            } else {
                count++;
            }
            sum = (sum+count) % MOD;
        }

        return sum;
    }
}
