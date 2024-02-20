class BinarySearchSlidingWindow {
    public int characterReplacement(String s, int k) {
        
        int lo = 1, hi = s.length() + 1;
        while (lo+1 < hi) {
            int mid = (hi-lo)/2 + lo;

            if (lengthValid(s, k, mid)) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        return lo;
    }

    private boolean lengthValid(String s, int k, int mid) {
        int[] freq = new int[26];
        int left = 0;
        int mostFrequentLetter = 0;

        for (int i = 0; i < s.length(); i++) {
            // update freq with new number
            // if window size is size, check validity
            // if valid, return true,
            // if not, slide right

            int letter = s.charAt(i)-'A';
            mostFrequentLetter = Math.max(mostFrequentLetter,++freq[letter]);
            
            int window = i - left + 1;
            if (window == mid) { // window size equal to our target
                if (mostFrequentLetter + k >= window) return true;

                freq[s.charAt(left)-'A']--; // remove right-most frequency
                left++; // slide right
            }
        }
        return false;
    }
}
