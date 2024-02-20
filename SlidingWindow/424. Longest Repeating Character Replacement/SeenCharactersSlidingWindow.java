class SeenCharactersSlidingWindow {
    public int characterReplacement(String s, int k) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            seen.add(c);
        }

        int max = 0;    
        for (Character c : seen) {
            // for each character, find it's max (i.e. a 'local' max), and max all seen characters' maxes.
            int count = 0;
            int left = 0;
            for (int right = 0; right < s.length(); right++) {
                if (s.charAt(right) == c) count++; // seen our target character, increment its count

                int window = right - left + 1;

                if (count + k >= window) { // valid window!
                    max = Math.max(max, window);
                } else {
                    // window too large, shrink it
                    if (s.charAt(left) == c) count--;
                    left++;
                }
            }
        }
        return max;
    }
}
