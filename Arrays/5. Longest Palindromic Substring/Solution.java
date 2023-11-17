/**
 * Learned:
 *   - Follow your intuitions, sometimes they work.
 */
class Solution {
    public String longestPalindrome(String s) {
        // a palindrome begins with either a double char or xcx

        char[] c = s.toCharArray();
        String res = s.substring(0,1);

        for (int i = 0; i < c.length; i++) {
            res = checkPali(c, s, res, i-1, i); // i as the right position of an even-numbered pali
            res = checkPali(c, s, res, i-1, i+1); // i as the middle position of an odd-numbered pali
        }
        return res;
    }

    private String checkPali(char[] c, String s, String res, int l, int r) {
        while (l >= 0 && r < c.length) {
            if (c[l] != c[r]) {
                break;
            } else {
                l--;
                r++;
            }
        }

        if (res.length() < (r-(l+1))) {
            return s.substring(l+1,r);
        }
        return res;
    }
}
