class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        // consider time it takes to collect any garbage type in one go
        // keep track of the highest index for each type

        int lastPaper = -1;
        int lastGlass = -1;
        int lastMetal = -1;
        int sum = 0;

        for (int i = garbage.length -1; i >= 0; i--) {
            String g = garbage[i];
            sum += g.length();
            if (lastPaper == -1 && g.contains("P")) {
                lastPaper = i;
            }
            if (lastGlass == -1 && g.contains("G")) {
                lastGlass = i;
            }
            if (lastMetal == -1 && g.contains("M")) {
                lastMetal = i;
            }
        }

        int highest = Math.max(Math.max(lastPaper, lastGlass), lastMetal);
        for (int i = 1; i <= highest; i++) {
            if (i <= lastPaper) {
                sum += travel[i-1];
            }
            if (i <= lastGlass) {
                sum += travel[i-1];
            }
            if (i <= lastMetal) {
                sum += travel[i-1];
            }
        }
        return sum;
    }
}
