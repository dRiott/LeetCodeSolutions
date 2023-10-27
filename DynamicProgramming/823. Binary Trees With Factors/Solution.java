/**
 * Learned:
 *   - After I thought it through, I did get sorting the array
 *   - I did intuit the Dynamic Programming concept
 *   - I struggled to figure out the actual calculation: (dp[i] + (factorJ * factorOther)) % mod;
 *   - I mistakenly expressed the mod as (int) 10e9 + 7; when it should have been (int) 1e9 + 7;
 */
class Solution {
    private static int mod = (int) 1e9 + 7;
    public int numFactoredBinaryTrees(int[] arr) {
        // find factors
        
        Arrays.sort(arr);
        
        long[] dp = new long[arr.length];
        Arrays.fill(dp, 1);

        // We'll need to effeciently look up indexes
        Map<Integer, Integer> indices = new HashMap<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            indices.put(arr[i], i); // value to index
        }


        // go through all arr, where i is the multiple of two smaller factors
        for (int i = 0; i < arr.length; i++) {
            // go through all of the potential factors, which must be lower than i
            for (int j = 0; j < i; j++) {

                // if j is a factor of i, grab the other factor as well
                if (arr[i] % arr[j] == 0) {
                    int otherFactor = arr[i] / arr[j];
                    // grab the index for that value

                    if (indices.containsKey(otherFactor)) {
                        // first factor
                        long factorJ = dp[j];
                        long factorOther = dp[indices.get(otherFactor)];

                        dp[i] = (dp[i] + (factorJ * factorOther)) % mod;
                    }
                }
            }
        }


        long res = 0;
        for (int i = 0; i < dp.length; i++) {
            res += dp[i];
        }
        return (int) (res % mod);
    }
}
