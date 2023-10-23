class BruteForcePrecomputed {
    public boolean isPowerOfFour(int n) {
        List<Integer> powers = new ArrayList<>(16);
        powers.add(1);
        int prevPower = 1;
        for (int i = 1; i < 16; i++) {
            prevPower = prevPower*4;
            powers.add(prevPower);
        }

        return powers.contains(n);
    }
}
