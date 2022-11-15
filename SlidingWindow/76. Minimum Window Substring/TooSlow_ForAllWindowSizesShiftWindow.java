class TooSlow_ForAllWindowSizesShiftWindow {
    public String minWindow(String s, String t) {
        // smallest substring of s that includes all characters in t

        if (s.length() < t.length()) return "";

        int[] freq = populate(t);

        // smallest window
        int window = t.length();
        while (window <= s.length()) {

            // two pointer, r and l
            int l=0, r = window;
            
            // do the letters btwn the window satisfy the freq?
            int[] test = populate(s.substring(l,r));
            while (r <= s.length()) {
                if (enoughChars(test, freq)) return s.substring(l,r);

                // shift window to the right
                if (++r <= s.length()) test[s.charAt(r-1)-'A']++;
                test[s.charAt(l++)-'A']--;
            }
            window+=1;
        }
        return "";
    }

    private boolean enoughChars(int[] test, int[] target) {
        for (int i = 0; i < target.length; i++) {
            if (test[i] < target[i]) return false;
        }
        return true;
    }

    private int[] populate(String t) {
        int[] freq = new int[58];
        for (char c : t.toCharArray()) {
            freq[c-'A']++;
        }
        return freq;
    }
}
