class Solution {
    private final int MOD = (int) 1e9 + 7;
    public int countHomogenous(String s) {
        
        char[] l = s.toCharArray();
        if (l.length == 0) return 0;

        char p = l[0];
        int count = 1;
        int sum = 0;
        for (int i = 1; i < l.length; i++) {
            if (l[i] != p) {
                sum += factorialSum(count);
                count = 1;
                p = l[i];
            } else {
                count++;
            }
        }
        sum+=factorialSum(count);

        return sum;
    }

    private int factorialSum(int s) {
        int sum = 0;
        for (int i = 1; i <= s; i++) {
            sum+=i;
            sum %= MOD;
        }
        return sum %= MOD;
    }
}
