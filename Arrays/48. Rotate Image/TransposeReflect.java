class TransposeReflect {
    // You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise). Do so in-place.
    public void rotate(int[][] matrix) {
        transpose(matrix);
        reflect(matrix);
    }

    private void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    private void reflect(int[][] matrix) {
        // for each row
        for (int i = 0; i < matrix.length; i++) {
            // reflect the row
            int j = 0, k = matrix.length-1;
            while (j < k) {
                int temp = matrix[i][j];
                matrix[i][j++] = matrix[i][k];
                matrix[i][k--] = temp;
            }
        }
    }


}
