class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (numOnes >= k) {
            return k;
        }

        int total = numOnes;
        int rem = k-numOnes - numZeros;

        if (rem <= 0) {
            return total;
        } else {
            return total - rem;
        }
    }
}
