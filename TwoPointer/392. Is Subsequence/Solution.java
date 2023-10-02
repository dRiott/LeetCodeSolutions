class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] small = s.toCharArray();
        char[] large = t.toCharArray();

        int i = 0, j = 0;
        while (i < small.length && j < large.length) {
            if (small[i] == large[j]) {
                i++;
            }
            j++;
        }
        return i == small.length;
    }
}
