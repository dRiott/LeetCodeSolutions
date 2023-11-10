class IterativeAdjacencyGraph {
    public int[] restoreArray(int[][] ap) {
        if (ap.length == 1) {
            return ap[0];
        }

        // build a graph where nodes all point to each other
        // we'll only move "forward" through the graph by checking where we came from,
        // i.e. maintaining a cursor, and a prev pointer, so we don't loop around on ourselves.
        Map<Integer,List<Integer>> s = new HashMap<>();
        for (int i = 0; i < ap.length; i++) {
            List<Integer> nodes = s.getOrDefault(ap[i][0], new ArrayList<>());
            nodes.add(ap[i][1]);
            s.put(ap[i][0], nodes);

            nodes = s.getOrDefault(ap[i][1], new ArrayList<>());
            nodes.add(ap[i][0]);
            s.put(ap[i][1], nodes);
        }

        // find a valid root
        int root = -1;
        for (Integer key : s.keySet()) {
           if (s.get(key).size() == 1) {
               root = key;
               break;
           }
        }
        
        int[] res = new int[s.size()];
        res[0] = root;

        int curr = root;
        int prev = Integer.MAX_VALUE;
        int i = 1;
        while (i < res.length) {
            for (int neighbor : s.get(curr)) { // go through neighbors
                if (neighbor != prev) { // if we haven't seen this already, it moves us forward through linked list
                    res[i] = neighbor;
                    i++;
                    prev = curr;
                    curr = neighbor;
                    break;
                }
            } 
        }
        
        return res;
    }
}
