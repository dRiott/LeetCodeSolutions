class BFS {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int numIslands = 0;

        int lenR = grid.length;
        int lenC = grid[0].length;

        for (int r = 0; r < lenR; r++) {
            for (int c = 0; c < lenC; c++){
                if (grid[r][c] == '1') {
                    numIslands++; // found an island!
                    grid[r][c] = '0'; // mark as visited

                    Deque<Integer> neighbors = new ArrayDeque<>();
                    neighbors.addLast(r * lenC + c);

                    while (!neighbors.isEmpty()) {
                        int id = neighbors.removeFirst();
                        int row = id / lenC;
                        int col = id % lenC;

                        // check all corners adjacent to see explore island
                        if (row - 1 >= 0 && grid[row-1][col] == '1') visit(grid, neighbors, lenC, row-1, col);
                        if (row + 1 < lenR && grid[row+1][col] == '1') visit(grid, neighbors, lenC, row+1, col);
                        if (col - 1 >= 0 && grid[row][col-1] == '1') visit(grid, neighbors, lenC, row, col-1);
                        if (col + 1 < lenC && grid[row][col+1] == '1') visit(grid, neighbors, lenC, row, col+1);
                    }
                }
            }
        }
        return numIslands;
    }

    private void visit(char[][] grid, Deque<Integer> neighbors, int lenC, int row, int col) {
        neighbors.add(row * lenC + col);
        grid[row][col] = '0';
    }
}
