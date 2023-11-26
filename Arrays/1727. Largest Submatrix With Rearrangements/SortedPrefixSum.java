/**
 * Learned:
 *   - Key insight: tracking the height that each column contributes,
 *     which is kind of like a prefix-sum
 */
class SortedPrefixSum {
    public int largestSubmatrix(int[][] matrix) {
        // for each column, create a min max of consequtive ones
        // sort these
        // a submatrix doesn't need to be a square, but a rectangle

        //when ever the min max changes, new boundary beings?


        int m = matrix.length;
        int n = matrix[0].length;
        int[] prevRow = new int[n];
        int res = 0;


        // go through all of the rows, and calculate
        for (int row = 0; row < m; row++) {
            int[] currRow = matrix[row].clone(); // prevent modifying input
            for (int i = 0; i < n; i++) {
                if (currRow[i] != 0) { // otherwise, reset the height with 0
                    currRow[i] += prevRow[i]; // prefix-sum height tracking
                }
            }

            int[] sortedRow = currRow.clone(); // preserve future prefix-sums
            Arrays.sort(sortedRow); // wouldn't want to sort the prefix-sum
            for (int i = n - 1; i >= 0; i--) {
                res = Math.max(res, (n-i)*sortedRow[i]);
            }

            prevRow = currRow;
        }

        return res;
    }
}
