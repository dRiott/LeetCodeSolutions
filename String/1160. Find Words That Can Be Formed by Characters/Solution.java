class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];
        int[] wf = new int[26];
        for (char c : chars.toCharArray()) {
            freq[c-'a']++;
        }
        int res = 0;
        for (String w : words) res += goodLength(w, wf, freq);
        return res;
    }

    private static int goodLength(String w, int[] wf, int[] freq) {
        Arrays.fill(wf, 0);
        for (char c : w.toCharArray()) {            
            if (freq[c-'a'] == 0) return 0; // haven't seen this letter
            if (++wf[c-'a'] > freq[c-'a']) return 0; // don't have enough
        }
        return w.length();
    }
}
