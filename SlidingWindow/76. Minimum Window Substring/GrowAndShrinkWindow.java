class GrowAndShrinkWindow {
    public String minWindow(String s, String t) {
        // smallest substring of s that includes all characters in t

        if (s.length() < t.length()) return "";

        // two pointer, r and l, starting with the smallest possible window
        int[] freq = populate(t), test = populate(s.substring(l,r));
        int l=0, r = t.length(), bestL = -1, bestR = -1, minLength = Integer.MAX_VALUE;

        while (r <= s.length()) {
            if (enoughChars(test, freq)) {
                int len = r-l;
                if (len < minLength) {
                    minLength = len;
                    bestL = l;
                    bestR = r;
                }
                // try shrinking more
                test[s.charAt(l++)-'A']--;    
            } else {
                // no match, increase window by adding to the right
                if (++r <= s.length()) test[s.charAt(r-1)-'A']++;
            }
        }

        return bestL == -1 ? "" : s.substring(bestL, bestR);
    }

    private boolean enoughChars(int[] test, int[] target) {
        for (int i = 0; i < target.length; i++) {
            if (test[i] < target[i]) return false;
        }
        return true;
    }

    private int[] populate(String t) {
        int[] freq = new int[58]; // ASCII table has A-Z, 6 other chars, then a-z
        for (char c : t.toCharArray()) {
            freq[c-'A']++;
        }
        return freq;
    }
}
