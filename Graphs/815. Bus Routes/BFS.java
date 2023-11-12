class Solution {

    public int numBusesToDestination(int[][] routes, int sourceStop, int targetStop) {
        if (sourceStop == targetStop) return 0;

        // stop numbers to other buses
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            int[] route = routes[bus];
            for (int r = 0; r < route.length; r++) {
                int stop = route[r];
                adj.putIfAbsent(stop, new ArrayList<>());
                adj.get(stop).add(bus);
            }
        }

        Queue<Integer> nextBusQueue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(routes.length);
        
        // all the possible bus stops from the source bus
        for (int bus : adj.get(sourceStop)) {
            nextBusQueue.add(bus);
            visited.add(bus);
        }

        int busCount = 1;
        while (!nextBusQueue.isEmpty()) {
            
            // BFS
            int size = nextBusQueue.size();
            for (int i = 0; i < size; i++) {   
                Integer bus = nextBusQueue.remove();
                int[] stops = routes[bus];
                for (int stop : stops) {
                    if (stop == targetStop) return busCount;

                    // plan to try out other buses accessible from this stop
                    for (int nextBus : adj.get(stop)) {
                        if (!visited.contains(nextBus)) {
                            nextBusQueue.add(nextBus);
                            visited.add(nextBus);
                        }
                    }
                }
            }
            busCount++; // current bus didn't get us there, we need one more
        }

        return -1;

    }
}
