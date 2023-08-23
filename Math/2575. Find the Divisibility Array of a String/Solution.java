class Solution {
    public int[] divisibilityArray(String word, int m) {
        // Insight is that you only need the mod of the previous positions division, not the whole-number division
        int[] res = new int[word.length()];

        long prevMod = 0;
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - '0';
            prevMod = ((prevMod*10) + curr) % m;
            if (prevMod == 0) {
                res[i] = 1;
            }
        }

        return res;
    }
}
