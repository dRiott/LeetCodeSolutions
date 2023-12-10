class Solution {
    public int[][] transpose(int[][] matrix) {
        if (matrix.length == 0) return matrix;

        int w = matrix.length, h = matrix[0].length;
        int[][] result = new int[h][w]; // swap width and height

        for (int row = 0; row < w; row++) {
            for (int col = 0; col < h; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }
}
