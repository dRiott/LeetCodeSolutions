// start with a brute-force solution and then optimize it
class TopDownDP {
    private static final int MOD = (int) 1e9 + 7;
    private Integer[][] cache;
    public int numRollsToTarget(int n, int k, int target) {
        // factors of target, max of k
        
        cache = new Integer[n+1][target+1];

        // start with 1 as the only possible 

        // iterate downwards, starting from n dice all the way to 0

        return waysToRoll(n, k, target, 0, 0);

    }

    private int waysToRoll(int n, int k, int target, int currSum, int currDice) {

        if (currDice == n) {
            // rolled all dice, did we find a way?
            return currSum == target ? 1 : 0;
        }

        if (cache[currDice][currSum] != null) {
            // we've already calculated this
            return cache[currDice][currSum];
        }

        int ways = 0;
        int diceValueMax = Math.min(k, target-currSum);
        for (int i = 1; i <= diceValueMax; i++) {
            ways = (ways + waysToRoll(n, k, target, currSum+i, currDice+1)) % MOD; // roll next die with value i
        }
        cache[currDice][currSum] = ways;
        return ways;
    }

}
