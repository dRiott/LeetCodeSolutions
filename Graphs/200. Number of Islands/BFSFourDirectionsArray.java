class BFSFourDirectionsArray {

    private static final int[] dirs = {0, 1, 0, -1, 0};

    public int numIslands(char[][] grid) {
        int numIslands = 0;

        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ++numIslands;
                }
            }
        }

        return numIslands;
    }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        grid[r][c] = 'v'; // Mark 'v' for visited
        q.offer(new int[] {r, c});

        while (!q.isEmpty()) {
            final int currR = q.peek()[0];
            final int currC = q.poll()[1];

            // search in all directions
            for (int d = 0; d < 4; d++) {
                final int nextR = currR + dirs[d]; 
                final int nextC = currC + dirs[d + 1];
                
                if (nextR < 0 || nextR == grid.length 
                    || nextC < 0 || nextC == grid[0].length
                    || grid[nextR][nextC] != '1') 
                    continue;
                
                grid[nextR][nextC] = 'v'; // Mark 'v' for visited
                q.offer(new int[] {nextR, nextC});
            }
        }
    }
}
