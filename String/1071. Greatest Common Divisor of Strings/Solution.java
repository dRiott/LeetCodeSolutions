class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String result = "";
        int m = 0;
        String smallest = str1.length() >= str2.length() ? str2 : str1;

        for (int i = 0; i < smallest.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            } else {
                m++;
                if (divisor(m, str1) && divisor(m, str2)) {
                    // update new best result
                    result = smallest.substring(0, m);
                }
            }
        }
        return result;
    }

    // Better way: if m fits n times into s, then concatenate m with itself n times and check whether result equals s
    private static boolean divisor(int m, String s) {
        // can str of length m be put into both strings?
        int original = m;
        if (original > s.length() || s.length() % m != 0) {
            return false;
        }
        String test = s.substring(0,m);
        while (m+original <= s.length()) {
            String next = s.substring(m, m+original);
            if (!next.equals(test)) {
                return false;
            }
            m+=original;
        }
        return true;
    }
}
