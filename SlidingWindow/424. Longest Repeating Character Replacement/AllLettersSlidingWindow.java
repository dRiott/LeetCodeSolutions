class AllLettersSlidingWindow {
    public int characterReplacement(String s, int k) {

        char[] nums = s.toCharArray();
        int max = 0;
        
        // for all characters, do this sliding window thing
        for (int letter = 0; letter < 26; letter++) {

            int end = 0, start = 0, letterMatchCount = 0;

            while (end < nums.length) {
                
                if (nums[end] - 'A' == letter) letterMatchCount++;

                int windowSize = (end+1) - start;

                if (windowSize - countLetter <= k) {
                    // valid window, try to update max
                    max = Math.max(max, windowSize);
                    end++; // try expanding window!
                } else {
                    // invalid window, bookkeep letterMatchCount, move start until valid again
                    if (letter == nums[start]-'A') letterMatchCount--; // a matching letter is leaving window
                    start++;
                }
            }
        }

        return max;
    }
}
