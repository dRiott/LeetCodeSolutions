class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer[]> stack = new Stack<>(); // 0: index, 1: value
        int[] res = new int[nums.length];
        Arrays.fill(res, Integer.MIN_VALUE);

        for (int j = 0; j < nums.length * 2; j++) {
            int i = j % nums.length;
            while (!stack.isEmpty() && nums[i] > stack.peek()[1]) {
                Integer[] item = stack.pop();
                res[item[0]] = nums[i];
            }
            stack.push(new Integer[]{i, nums[i]});
        }

        while (!stack.isEmpty()) {
            Integer[] item = stack.pop();
            if (res[item[0]] == Integer.MIN_VALUE) {
                res[item[0]] = -1;
            }
        }
    
        return res;
    }
}
