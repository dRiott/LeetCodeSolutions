/** 
 * Left all of my notes as I thought through the problem
 * Note "checking for seen positions to invalidate" is the boolean[] of other solutions.
 * Here, we cheat with a hashset instead; a little easier.
 */
class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        // l and r represent a subsequence of nums
        // "sort l (moving r correctly)?"
        
        // what would rearrange mean?
        // sort the subsequence
        // cal the diff between first two, ensure all others are same..

        // maintain map<integer, integer> of the original indices?

        // go through nums, building up all answers?
        // do without sorting?

        
        // build a hashmap of start -> end
        // iterate through l, lookup start, check whether end >= r
        
        // 2 nums -> diff between them
        // 3 nums: 1,2,3 1,3,2 3,1,2, 
        // find smallest and largest, diff, divide by size - 1 == arithm
        // generate the sequence
        // iterate through, checking for seen positions to invalidate
        // For efficient checks, we will convert arr to a hash set.
        List<Boolean> result = new ArrayList(l.length);
        for (int i = 0; i < l.length; i++) {
            int curr = l[i], left = l[i], right = r[i];
            Set<Integer> vals = new HashSet<>(); //todo rid of me
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            while (curr <= right) {
                int val = nums[curr++];
                vals.add(val);
                min = Math.min(min, val);
                max = Math.max(max, val);
            }
            int divisor = right-left;
            if ((max-min)%divisor != 0) {
                result.add(false);
                continue;
            }

            int diff = (max-min) / divisor;
            curr = min;
            boolean res = true;
            while (curr < max) {
                curr+=diff;
                if (!vals.contains(curr)) {
                    res = false;
                    break;
                }
            }

            result.add(res);
        }
        return result;
    }
}
