class Solution {
    public String largestGoodInteger(String num) {
        char[] let = num.toCharArray();
        if (let.length == 0) return "";

        int prev = let[0]-'0';
        int count = 1;
        int max = -1;
        int start = -1;
        int val = -1;
        for (int i = 1; i < let.length; i++) {
            val = let[i]-'0';
            if (val == prev) {
                count++;
            } else {
                if (count >= 3 && prev > max) {
                    max = prev;
                    start = i-count;
                }
                prev = val;
                count = 1;
            }
        }
        if (count >= 3 && val > max) {
            max = val;
            start = num.length() - count;
        }

        if (max == -1) return "";
        return num.substring(start, start+3);
    }
}
