class BFS {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if (maze.length == 0 || maze[0].length == 0) return false;
        int w = maze.length, h = maze[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};

        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{start[0], start[1]});
        boolean visited[][] = new boolean[w][h];
        while (!q.isEmpty()) {
            int[] pos = q.removeLast();
            int r = pos[0], c = pos[1];
            if (r == destination[0] && c == destination[1]) return true;
            visited[r][c] = true; // visit
            
            // for all directions,
            for (int i = 1; i < dirs.length; i++) {
                // go in that direction as far as possible
                int nextR = r + dirs[i-1];
                int nextC = c + dirs[i];

                while (inBounds(w, h, nextR, nextC) && hasPath(maze, nextR, nextC)) {
                    nextR+=dirs[i-1];
                    nextC+=dirs[i];
                }

                nextR-=dirs[i-1];
                nextC-=dirs[i];
                if (!visited[nextR][nextC]) {
                    q.addLast(new int[]{nextR,nextC});
                    visited[nextR][nextC] = true;
                }
                
            }
        }
        return false;
    }

    private boolean inBounds(int w, int h, int r, int c) {
        return r >=0 && r < w && c >= 0 && c < h;
    }

    private boolean hasPath(int[][] maze, int r, int c) {
        return maze[r][c] == 0;
    }
}
