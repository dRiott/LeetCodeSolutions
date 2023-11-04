/**
 * Learned:
 *   - Walk through examples and consider the possible intuitions to see patterns.
 */
class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        // two ants colliding and simply passing through each other are identical scenarios.
        // ignore who is hitting who, as we consider their positions just swapping
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < left.length; i++) {
            max = Math.max(max, left[i]);
        }

        // I had the correct idea, but I just used right[i], instead of n-right[i]!
        for (int i = 0; i < right.length; i++) {
            max = Math.max(max, n - right[i]);
        }
        return max;
    }
}
