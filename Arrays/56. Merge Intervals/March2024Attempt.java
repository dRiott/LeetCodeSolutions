class March2024Attempt {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;

        // biggest insight: need to sort them!
        Arrays.sort(intervals, (one, two) -> one[0] - two[0]);

        List<int[]> l = new ArrayList<>();

        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            
            // question: add prev as is, or expand it?
            int[] curr = intervals[i];
            if (prev[1] >= curr[0]) {
                if (prev[1] < curr[1]) {
                    prev[1] = curr[1];
                }
            } else {
                l.add(prev);
                prev = curr;
            }
        }

        if (l.isEmpty() || l.get(l.size()-1) != prev) {
            l.add(prev);
        }

        return l.toArray(new int[0][]);
    }
}
