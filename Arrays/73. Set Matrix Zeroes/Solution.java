class Solution {
    /*
      Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
    */
    public void setZeroes(int[][] matrix) {
        // one pass to find a set of rows, cols
        // second pass to implement
        
        // size of the set of rows == count of rows, == m
        // size of set of cols == count of cols == n
        // space = m + n

        // i started looking for a means to indicate within the content of the cell:
        // however, I noticed that the value of a cell could be the entire span of Integer values, so not helpful
        // Editorial has an idea: use the _first_ cell in a row and col to indicate (i.e. "flag") the cell and row to be 0'ed out.
        // However, there's a collision on [0][0] -- was it a zero in the row or in the col? Choose one to donote row, and use another variable for first col.

        int r = matrix.length, c = matrix[0].length;
        boolean isZeroInFirstCol = false;
        for (int i = 0; i < r; ++i) {
            if (matrix[i][0] == 0) {
                isZeroInFirstCol = true; // cell in the first col uses the variable
            }

            // j == 1, skipping the first col, since we're using another variable for that
            for (int j = 1; j < c; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < r; ++i) {
            for (int j = 1; j < c; ++j) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // must come first, so the isZeroInFirstCol doesn't overwrite our flag in matrix[0][0]
        if (matrix[0][0] == 0) {
            for (int j = 0; j < c; ++j) {
                matrix[0][j] = 0;
            }
        }

        if (isZeroInFirstCol) {
            for (int i = 0; i < r; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
