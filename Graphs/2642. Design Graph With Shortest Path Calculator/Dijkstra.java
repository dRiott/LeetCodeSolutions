class Dijkstra {

    Map<Integer, List<Pair<Integer, Integer>>> adj;
    Integer size;

    public Graph(int n, int[][] edges) {
        size = n;
        adj = new HashMap<>(n);
        for (int i = 0; i < edges.length; i++) {
            this.addEdge(edges[i]);
        }
    }
    
    public void addEdge(int[] r) {
        int source = r[0], dest = r[1], weight = r[2];
        adj.putIfAbsent(source, new ArrayList<>());
        adj.get(source).add(new Pair(dest, weight));     
    }
    
    public int shortestPath(int source, int target) {
        int[] res = new int[size];
        Arrays.fill(res, Integer.MAX_VALUE);

        Queue<Pair<Integer,Integer>> pq = new PriorityQueue<>(Comparator.comparing(Pair::getValue));
        res[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair<Integer,Integer> p = pq.remove();
            int curr = p.getKey();
            int currWeight = p.getValue();

            if (res[curr] < currWeight) continue;
            if (curr == target) return currWeight; // we're done if we found it
            if (!adj.containsKey(curr)) continue;

            for (Pair<Integer, Integer> nPair : adj.get(curr)) {
                int neighbor = nPair.getKey();
                int neighborWeight = nPair.getValue();
                int newCost = currWeight + neighborWeight;
                if (newCost < res[neighbor]) {
                    res[neighbor] = newCost;
                    pq.add(new Pair(neighbor, newCost));
                }
            }
        }

        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
