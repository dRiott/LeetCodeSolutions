class ReallyFastSolution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        final int n = s.length();
        if (n <= 2)  return n;
        byte[] sc = new byte[n];
        s.getBytes(0, n, sc, 0);
        
        final int[] counts = new int[128];
        int left = 0;
        int right = 0;
        int distinctCount = 0;
        int maxLen = 0;
        
        while (right < n) {
            if (counts[sc[right++]]++ == 0) {
                if (++distinctCount > 2) {
                    maxLen = Math.max(maxLen, right - left - 1);
                    while (--counts[sc[left++]] != 0)  { }
                    distinctCount--;
                }
            }
        }
        
        return Math.max(maxLen, n - left);
    }
}
