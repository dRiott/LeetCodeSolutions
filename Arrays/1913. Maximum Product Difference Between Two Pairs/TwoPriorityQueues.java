class TwoPriorityQueues {
    public int maxProductDifference(int[] nums) {
        // find largest and second largest
        // find smallest and second smallest
        PriorityQueue<Integer> largest = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        for (int i : nums) {
            largest.offer(i);
            smallest.offer(i);
        }

        return (largest.poll() * largest.poll()) - (smallest.poll() * smallest.poll());
    }
}
