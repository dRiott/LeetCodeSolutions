class UnionFindWithRank {
    
    private int[] roots;
    private int[] ranks;
    private int provinces;
    
    // return the total number of disjoint sets
    public int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        roots = new int[len];
        ranks = new int[len];
        provinces = len;
        
        // build up ranks and roots
        for (int i = 0; i < len; i++) {
            roots[i] = i;
            ranks[i] = 1;
        }
        
        // join with union
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return provinces;
    }
    
    private int find(int x) {
        if (x == roots[x]) return x;
        return roots[x] = find(roots[x]);
    }
    
    private void union(int x, int y) {
        int rootX = find(x), rootY = find(y);

        if (rootX != rootY) {
            if (ranks[rootX] > ranks[rootY]) {
                roots[rootY] = rootX;
            } else if (ranks[rootY] > ranks[rootX]) {
                roots[rootX] = rootY;
            } else {
                roots[rootX] = rootY;
                ranks[rootY] += ranks[rootX];
            }
            provinces -= 1;
        }
    }
}
