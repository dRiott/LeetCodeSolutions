class TopDownDP {
    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length) return -1;

        // put as many hard jobs on the same day as you can
        // spread out easy jobs among d jobs

        // cache is task number, and days
        int[][] cache = new int[jobDifficulty.length][d+1]; // job day, tasks on day
        for (int i = 0; i < cache.length; i++) {
            Arrays.fill(cache[i], -1);
        }

        return minimumDifficulty(jobDifficulty, cache, 0, d);
    }

    /**
        When starting from the {@param task}, with {@param remainingDays} remaining, 
        returns the minimum difficulty for scheduled jobs on that day.
     */
    private int minimumDifficulty(int[] jd, int[][] cache, int task, int remainingDays) {
        // check cache 
        if (cache[task][remainingDays] != -1) {
            return cache[task][remainingDays];
        }

        if (remainingDays == 1) {
            // base case: with 1 day left, all remaining tasks must be scheduled
            int max = 0;
            for (int i = task; i < jd.length; i++) {
                // go through all remaining task, calculate their maximum, and return it
                max = Math.max(max, jd[i]);
            }
            return max; // return the maximum for that day.
        }


        int singleDayMax = 0;
        int minWork = Integer.MAX_VALUE;

        // all possible combinations
        // to have at least one task for each remaining day, limit our upper bound
        // for 10 tasks, and 10 remaining days, you must be on the first task (i==0) and iterate once
        for (int i = task; i < jd.length-remainingDays+1; i++) {
            // you could do one task, or two, or three, but you always consume one day.
            // of all these possible allocations, which is the smallest?
            
            // calculate the max amount of work for all days considered
            singleDayMax = Math.max(singleDayMax, jd[i]);

            // min amount of work across all days
            minWork = Math.min(minWork, singleDayMax + minimumDifficulty(jd, cache, i+1, remainingDays-1));
        }

        cache[task][remainingDays] = minWork;
        return minWork;
    }
}
