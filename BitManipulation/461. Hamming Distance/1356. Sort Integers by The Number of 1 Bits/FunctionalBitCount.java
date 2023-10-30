/**
 * Learned:
 *   - Remeber the built-ins: Integer::bitCount
 */
class Solution {
    public int[] sortByBits(int[] arr) {
         return Arrays.stream(arr)
             .boxed()
             .sorted(Comparator.comparing(Integer::bitCount).thenComparing((a,b) -> a - b))
             .mapToInt(x -> x)
             .toArray(); 
    }
}
