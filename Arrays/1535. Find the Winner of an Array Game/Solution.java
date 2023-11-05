/**
 * Learned:
 *   - At first, I didn't have the k>arr.length check, which meant continuing to loop through the queue, 
       when that's not logically necessary, since it won't change the outcome, and wastes time.
 *   - I did have a case for many loops, but it didn't trigger TIME LIMIT EXCEEDED. 
       Use the _max value_ from description, instead of an arbitrarily large number.
 *   - Technically, the doubly-ended queue isn't necessary, since logically you can just pass through once,
       and therefore don't have to maintain the Deque.
 *   - The HashMap also isn't necessary, since you can just maintain a winStreak counter and reset it.
 */
class Solution {
    public int getWinner(int[] arr, int k) {

        if (k > arr.length) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < arr.length; ++i) {
                max = Math.max(max, arr[i]);
            }
            return max;
        }
        
        Map<Integer,Integer> wins = new HashMap<>();
        int winner = arr[0];
        int winnerCount = 0;

        Deque<Integer> dll = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            dll.addLast(arr[i]);
        }

        while (winnerCount < k) {
            Integer lead = dll.removeFirst();
            Integer next = dll.peek();
            Integer won = null;
            if (lead < next) {
                // change leaders
                dll.addLast(lead);
                won = next;
            } else {
                // leader still in the lead
                dll.addLast(dll.removeFirst());
                dll.addFirst(lead);
                won = lead;
            }
            int newWinCount = wins.getOrDefault(won, 0) + 1;
            wins.put(won, newWinCount);
            if (newWinCount > winnerCount) {
                winner = won;
                winnerCount = newWinCount;
            }
        }
        
        return winner;
    }
}
