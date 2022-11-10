class MapWithPrevIndexes {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> seen = new HashMap<>();
        char[] chars = s.toCharArray();
        int maxLen = 0, left = 0, right = 0;

        while (right < chars.length) {
            Integer index = seen.get(chars[right]);
            // only update left if index of duplicate is still within bounds
            if (index != null && index >= left) {
                left = index + 1;                
            }
            maxLen = Math.max(maxLen, right - left + 1);
            seen.put(chars[right], right);
            right++;
        }
        return maxLen;
    }
}
