/**
 * Learned:
 *   - Obviously I first thought of a PriorityQueue... trick is I didn't recognize that it's easy
 *     to represent the "reserved" state as simply present or not present in the queue.
 */
class SeatManager {

    private PriorityQueue<Integer> res;

    public SeatManager(int n) {
        res = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            res.offer(i);
        }
    }
    
    public int reserve() {
        return (int) res.poll();
    }
    
    public void unreserve(int seatNumber) {
        res.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
