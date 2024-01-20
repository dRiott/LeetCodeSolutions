/**
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
 * If there is no next greater element, then the answer for this query is -1.
 */
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && nums2[i] > stack.peek()) {
                // if the current i is _larger_ than what's on the stack
                // then each item on the stack's _next largest number is i
                // record them!
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        // we may have large numbers left
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1); // no element larger than what is popped
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
