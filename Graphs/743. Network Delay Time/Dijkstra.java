/*
 * Learned:
 *   - First time implementing Dijkstra's!
 */
class Dijkstra {
    Map<Integer, List<Pair<Integer,Integer>>> adj;

    public int networkDelayTime(int[][] times, int n, int k) {
        // k is the starting node
        // return the minimum time it takes for _all n nodes_ to receive the signal
 
        adj = new HashMap<>(n);
        for (int i = 0; i < times.length; i++) {
            int[] edge = times[i];
            adj.putIfAbsent(edge[0], new ArrayList<>());
            adj.get(edge[0]).add(new Pair(edge[1], edge[2])); // row 0 == start, row 1 == dest, row 2 == weight
        }

       int[] res = new int[n+1];
       Arrays.fill(res, Integer.MAX_VALUE); // to begin, we initialize everything to infinity (no possibility to reach)

        dijkstrasAlgorithm(res, k, n); // starting at k as the source, try to reach n nodes, updating res with the cost

        int max = Integer.MIN_VALUE;
        for (int i = 1; i < res.length; i++) {
            if (res[i] == Integer.MAX_VALUE) {
                 // if a node costs infinity, that's the init default value, and it's unreachable
                return -1;
            }
            max = Math.max(max, res[i]);
        }
        return max;
    }

    private void dijkstrasAlgorithm(int[] res, int start, int nodeCount) {
        // create a priority queue that preserves the neighbor with smallest weight
        // The Pair here is keyed by destination node, with value as the weight: keep the smallest weights on top
        Queue<Pair<Integer, Integer>> pq = new PriorityQueue<Pair<Integer,Integer>>(Comparator.comparing(Pair::getValue));

        res[start] = 0; // start (source) node has a 0 weight (cost) to reach itself
        pq.add(new Pair(start, 0)); // begin with the start (source) node
        
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> pair = pq.remove();

            int node = pair.getKey();
            int weight = pair.getValue();

            if (res[node] < weight) continue; // best time for this node is better than the one we're seeing now

            if (!adj.containsKey(node)) continue; // we don't know about this node


            // Add the adjacent node neighborNode to the priority queue 
            // only if the current path takes less time than the value we have presently...

            // for all of the possible neighbors
            for (Pair<Integer,Integer> np : adj.get(node)) {
                int neighbor = np.getKey();
                int neighborWeight = np.getValue();

                // if our prev cost (weight), plus weight to reach neighbor (neighborWeight) is an improvement, add the neighbor 
                if (res[neighbor] > weight + neighborWeight) {
                    res[neighbor] = weight + neighborWeight;
                    pq.add(new Pair(neighbor, res[neighbor]));
                }
            }
        }
    }
}
