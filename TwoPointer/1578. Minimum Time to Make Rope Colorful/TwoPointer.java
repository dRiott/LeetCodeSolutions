class TwoPointer {
    /*
     * Each char in colors is a balloon of that color.
     * Minimum cost it takes to remove balloons until no consequtive colors exist.
     */
    public int minCost(String colors, int[] neededTime) {
        int i = 0, j = 0;
        int res = 0;

        while (i < neededTime.length && j < neededTime.length) {

            // iterate over the same color with two pointers
            int cost = 0, max = 0; // max will be the one balloon of a given color we're leaving intact (highest cost)
            while (j < neededTime.length && colors.charAt(i) == colors.charAt(j)) {
                cost += neededTime[j];
                max = Math.max(max, neededTime[j]);
                j++;
            }

            res += cost - max; // cost of all balloons deleted, minus the highest cost, which is kept
            i = j;
        }

        return res;
    }
}
