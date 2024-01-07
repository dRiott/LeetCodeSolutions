class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        // compare two elements in the array --> one arithmetic sequence to check
        // compare all elements in the array with each other --> all posible arithemetic sequences

        // 2d cache -> for an arithmetic sequence, how many sequences at position i in the array
        // intuitively, i thought of the difference as the first dimension of the array; flip to make it easier

        // DP:
        // First step, define what state you need.
        // Second step, try to determine the state transitions based on the initial state representation
        // dp[i][delta] = number of arithmetic subsequences of [arr[1]..arr[i]] that ends in arr[i] and with the difference between adjacent elements equal to delta.

        // the number of pairs in an array is n*(n-1)/2... e.g. 4: 4*3=12/2=6. 
    

        int n = nums.length;
        int[][] dp = new int[n][n];

        // map of the number in nums to a list of all indices with this same value. List ordered asc by dint of iteration through nums
        HashMap<Long, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            long temp = nums[i];
            if(!map.containsKey(temp)){
                map.put(temp, new ArrayList<Integer>());
            }
            map.get(temp).add(i);
        }

        int sum = 0;
        for(int i = 1; i < n; i++){
            for(int j = i + 1; j < n; j++){
                long a = 2L * nums[i] - nums[j]; // a is the first number in a subsequence of a, nums[i], nums[j]; brilliant!
                if(map.containsKey(a) ){
                    for(int k : map.get(a)){ // for all indices with value a, if they're smaller than i (2nd number in subsequence), count 'em!
                        if(k < i){
                            int prev = dp[k][i];
                            dp[i][j] += prev + 1;
                        }else{
                            break;
                        }
                    }
                }
                sum += dp[i][j];
            }
        }
        return sum;
    }
}
