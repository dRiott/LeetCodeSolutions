/*
 * Learned:
 * - DP characteristics: need the max/min, and previous decisions impact current.
 * - DP is based on _overlapping subproblems_ and _optimal substructure_
 *     - Thus, break up the problem in to smaller subproblems, recurrences
 *     - And find how they relate to each other, the _recurrence relation_
 * - Phrased another way, David thinks the key is to "bring along with you" the sum of both pathways, as you go.
 * - This is called "Bottom-Up Dynamic Programming (Tabulation)"
 */
class BottomUpTabulation {

    public int minCostClimbingStairs(int[] cost) {

        // the minimum cost to reach i, is
        // the min between the cost to reach the previous step, plus the cost of that step
        //   and the cost to reach two steps ago, plus the cost of that step

        // minimumCost[i] = Math.min(minimumCost[i-1]+cost[i-1], minimumCost[i-2]+cost[i-2]);
        // Since we can start at either 0 or 1, both have a cost of 0 to reach: base case!

        // Starting at 2, the cost to reach 2...

        int[] minimumCost = new int[cost.length+1]; // +1 since we need to reach step beyond final

        for (int i = 2; i < minimumCost.length; i++) {
             minimumCost[i] = Math.min(minimumCost[i-1]+cost[i-1], minimumCost[i-2]+cost[i-2]);
        }

        return minimumCost[minimumCost.length-1];
    }
}
