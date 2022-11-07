class PriorityQueueComparator {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int i : nums) {
            freq.compute(i, (key, v) -> v == null ? 1 : v+1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue((n1, n2) -> freq.get(n1) - freq.get(n2));

        for(Integer key : freq.keySet()) {
          queue.add(key);
          if (queue.size() > k) queue.poll();
        }

        int[] result = new int[k];
        int count = k-1;
        while (!queue.isEmpty()) {
          result[count--] = queue.poll();
        }
        return result;
    }
}
