class Solution {

    public int[][] candyCrush(int[][] board) {
        boolean crushing = true;
        while (crushing) {
            crushing = crush(board);
        }
        
        return board;
    }

    private boolean crush(int[][] board) {        
        Set<int[]> set = new HashSet<>();
        // check vertical
        for (int col = 0; col < board[0].length; col++) {
            for (int row = 1; row < board.length - 1; row++) {
                if (board[row][col] != 0 && board[row+1][col] == board[row][col] && board[row][col] == board[row-1][col]) {
                    set.add(new int[]{row, col});
                    set.add(new int[]{row+1, col});
                    set.add(new int[]{row-1, col});
                }
            }
        }

        // check horizontal
        for (int row = board.length - 1; row >= 0; row--) {
            for (int col = 1; col < board[row].length -1; col++) {
                if (board[row][col] != 0 && board[row][col+1] == board[row][col] && board[row][col] == board[row][col-1]) {
                    set.add(new int[]{row, col});
                    set.add(new int[]{row, col+1});
                    set.add(new int[]{row, col-1});
                }
            }
        }


        if (set.isEmpty()) {
            return false;
        }

        // set 0s
        for (int[] toSetZero : set) {
            board[toSetZero[0]][toSetZero[1]] = 0;
        }


        for (int col = 0; col < board[0].length; col++) {
            int lowestZero = -1;

            // Iterate over each column backwards
            for (int row = board.length - 1; row >= 0; row--) {
                if (board[row][col] == 0) {
                    lowestZero = Math.max(lowestZero, row);
                } else if (lowestZero >= 0) {
                    int temp = board[row][col];
                    board[row][col] = board[lowestZero][col];
                    board[lowestZero][col] = temp;
                    lowestZero--;
                }
            }
        }
        // squash 0s, broken impl?

        // for (int row = 0; row < board[0].length; row++) {
            
        //     for (int col = board.length - 1; col >= 0; col--) {
        //         if (board[col][row] == 0) {
        //             // stretch vertically for all 0s
        //             int colStart = col;
        //             while (col-1 >= 0 && board[col-1][row] == 0) {
        //                 col--;
        //             }

        //             // replace from colStart to col inclusive
        //             int len = colStart - col + 1;
        //             for (int start = colStart; start-len >= 0; start--) {
        //                 board[start][row] = board[start-len][row];
        //                 board[start-len][row] = 0;
        //             }
        //         }
        //     }
        // }
        return true;
    }
}
