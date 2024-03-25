class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // binary search a sorted matrix
        // search for the row, search for the value
        // target may not be present
        // some tricky edge cases, potentially:, e.g. target 0 or 61 in 1st example
        
        int c = findRow(matrix, target);
        if (c < 0 || c >= matrix.length) return false;

        Integer i = findTarget(matrix[c], target);

        return i != null;
    }

    private int findRow(int[][] matrix, int target) {
        int lo = 0, hi = matrix.length - 1, r = matrix[0].length;
        
        while (lo < hi) {
            int mid = (hi-lo)/2 + lo;
            if (matrix[mid][0] <= target && matrix[mid][r-1] >= target) {
                return mid;
            } else if (matrix[mid][0] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private Integer findTarget(int[] row, int target) {
        int lo = 0, hi = row.length - 1;

        while (lo < hi) {
            int mid = (hi-lo)/2 + lo;
            if (row[mid] == target) {
                return mid;
            } else if (row[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return row[lo] == target ? lo : null;
    }
}
