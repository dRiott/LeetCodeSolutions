class BFS {
    
    // return the total number of disjoint sets
    public int findCircleNum(int[][] isConnected) {

        // bfs with count
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < isConnected.length; i++) {

            if (visited[i] == false) {
                queue.addLast(i);
                while (!queue.isEmpty()) {
                    // add all connected components to 
                    int node = queue.removeFirst();
                    visited[node]=true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (isConnected[node][j] == 1 && visited[j] == false) {
                            queue.addLast(j);
                        }
                    }
                }
                count++;
            }
        }        
        return count;
    }
}
