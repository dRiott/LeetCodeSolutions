class SortedIntervalMerge {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> l = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            
            if (l.isEmpty() || l.getLast()[1] < intervals[i][0]) {
                l.add(intervals[i]);
            } else {
                l.getLast()[1] = Math.max(l.getLast()[1], intervals[i][1]);
            }
        }
      
        return l.toArray(new int[l.size()][]);

    }
}
