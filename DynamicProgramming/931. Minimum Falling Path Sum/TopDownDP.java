class TopDownDP {
    public int minFallingPathSum(int[][] matrix) {
        int res = Integer.MAX_VALUE;
        Integer[][] memo = new Integer[matrix.length][matrix[0].length]; // cache of row, col

        // starting from each cell in the top row
        for (int i = 0; i < matrix.length; i++) {
            res = Math.min(res, dpMin(matrix, memo, 0, i));
        }

        return res;
    }

    private int dpMin(int[][] matrix, Integer[][] memo, int row, int cell) {
        if (cell < 0 || cell == matrix.length) {
            // out of bounds
            return Integer.MAX_VALUE;
        }
        
        if (row == matrix.length - 1) {
            // at the last row, no more progressions onto deeper rows
            // return the value at this position to be compared against min
            return matrix[row][cell];
        }


        if (memo[row][cell] != null) {
            return memo[row][cell];
        }

        int left = dpMin(matrix, memo, row+1, cell-1);
        int center = dpMin(matrix, memo, row+1, cell);
        int right = dpMin(matrix, memo, row+1, cell+1);

        int min = Math.min(left, Math.min(center, right)) + matrix[row][cell];
        return memo[row][cell] = min;
    }
}
