class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int l = 0, max = 0;
        Map<Character, Integer> seen = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            seen.put(c, r);

            if (seen.size() == 3) {
                int del_idx = Collections.min(seen.values());
                seen.remove(s.charAt(del_idx));
                l = del_idx+1;
            }

            max = Math.max(max, r-l+1);
        }   

        return max;
    }
}
