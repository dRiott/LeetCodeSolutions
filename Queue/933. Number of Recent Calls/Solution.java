class RecentCounter {

    private Deque<Integer> q = new ArrayDeque<>();

    public RecentCounter() {
        
    }
    
    public int ping(int t) {
        q.addLast(t);
        int oldest = t - 3000;
        while (q.peek() < oldest) {
            q.removeFirst();
        }
        return q.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
