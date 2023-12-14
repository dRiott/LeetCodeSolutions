class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        // each row: count ones minus counts 0
        int m = grid.length;
        int n = grid[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int val = grid[r][c] == 1 ? 1 : -1;
                rowCount[r] += val;
                colCount[c] += val;
            }
        }

        int[][] diff = new int[m][n];
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                diff[r][c] = rowCount[r] + colCount[c];
            }
        }
        return diff;
    }
}
