/** 
 * Learned: Pigs as qubits!
 *   - The bit is expressed as a number of possible states. For binary bits, that's 0 or 1
 *   - But for "qubits" (quantum bits), that number could be more than 2 possible states...
 *   - Here, the pigs have 2 possible states after each round: 0 (dead) or 1 (alive)
 *   - But with multiple rounds, their possible states increases to rounds+1 
 *   - E.g. 3 rounds: alive/alive/alive, alive/alive/dead, alive/dead/dead, dead/dead/dead
 *   - I wasn't thinkging about this problem in the way that the solution is... that it's more
 *   - about the number of states and combinations that make buckets, i.e. states^pigs == buckets
 *   - It's a hard one for the intuition, and the difficulty in seeing the formula from description.
 */
class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        /*
        // MY FAILED SOLUTION:

        buckets = buckets - 1; // always save a bucket no pigs must eat
        int numRounds = (int) minutesToTest/minutesToDie;
        buckets = (int) Math.ceil((double) buckets/numRounds); // buckets per round
        
        // int x = y + (y*(y-1))/2
        //  y = (-1 + √(1 + 8x)) / 2

        //  pigs = (-1 + √(1 + 8x)) / 2
        int pigs = (int) (Math.ceil(Math.sqrt(1 + 8*buckets)) - 1) / 2;
        return pigs;

        */

        // DEDUCING THE FORMULA... WRONGLY
        // 2 pigs: 2 + 1 (shared) == 3 + 1 == 4;
        // n pigs: nPigs + n-1Pigs
        // 3 pigs: 3 + 2
        // 4 pigs: 4 pigs + 3?

        // 1: 1,5,7,9
        // 2: 2,5,8,10
        // 3: 3,6,7,10
        // 4: 4,6,8,,9

        // 4 == 10
        // needed pigs: n + n*(n-1)/2
        // where x == buckets, y == pigs...
        // int x = y + (y*(y-1))/2
        //  y = (-1 + √(1 + 8x)) / 2


        // THE SOLUTION:
        // My approach wasn't bad, but my formula was wrong.
        // It's not y + y(y-1)/2...
        // It's 2^y, where 2 is the number of states (e.g. with 1 round, only 2: alive/dead)
        // But with multiple rounds, the number of states increases 
        // E.g. (alive after 1, alive after 2, dead after 1, dead after 2..)

        // Therefore, the real equation is: buckets = states^pigs
        // Hence the problem is to find x such that states^x ≥ buckets
        // where x is a number of pigs, states = minutesToTest / minutesToDie + 1

        // i.e. x >= log(states) * buckets
        // i.e. x >= log(buckets) / log(states)
        
        /* LeetCode provides:
        int states = minutesToTest / minutesToDie + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(states) - 1e-10);
        */
        
        // Everyone else seems to express it this way:
        int testsPerPig = minutesToTest / minutesToDie;
        int i=0;
        while(Math.pow(testsPerPig+1,i) < buckets) { // i.e. until states^pigs >= buckets...
            i++;
        }
        return i;
        
        /* Another way of thinking about the same:
        int testsPerPig = minutesToTest / minutesToDie;
        int numPigs = 0;
        int states = 1; // Number of unique states a pig can represent   
        while (states < buckets) {
            states *= (testsPerPig + 1);
            numPigs++;
        }
        return numPigs;
        */
    }
}
