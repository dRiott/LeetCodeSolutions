class PriorityQueue {
    public int eliminateMaximum(int[] dist, int[] speed) {
        // calculate the minutes before each monster arrives
        // priorityqueue of moster arrivals
        // counter of minutes spent eliminating monsters
        // poll from queue, subtract minutes, eliminate monster or fail

        PriorityQueue<Float> closest = new PriorityQueue<>();
        for (int i = 0; i < dist.length; ++i) {
            closest.offer((float) dist[i]/speed[i]);
        }
        
        int countEliminated = 0;
        while (!closest.isEmpty()) {
            Float m = closest.poll();
            if (m - countEliminated > 0) {
                countEliminated++;
            } else {
                return countEliminated;
            }
        }
        return countEliminated;
    }
}
