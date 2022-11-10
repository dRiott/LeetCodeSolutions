class ClassicDP {
    public int climbStairs(int n) {
        int one = 1, two = 1;
        for (int i = 0; i < n-1; i++) {
            int temp = one;
             // number of ways to reach ith step is sum of total ways to reach i-1 and i-2.
            one = one + two;
            two = temp;
        }
        return one;
    }
}
