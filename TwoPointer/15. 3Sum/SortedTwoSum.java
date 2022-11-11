class SortedTwoSum {
    public List<List<Integer>> threeSum(int[] nums) {
 
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
           // no values to the right can sum to 0
          if (i == 0 || nums[i-1] != nums[i]) {
            ans.addAll(twoPointerSum(nums, i));
          }
        }

        return ans;
    }

    private List<List<Integer>> twoPointerSum(int[] nums, int i) {
      int low = i+1, high = nums.length -1;
      List<List<Integer>> ans = new ArrayList<>();

      while (low < high) {
        int val = nums[i] + nums[low] + nums[high];
        
        if (val < 0) {
          low++;
        } else if (val > 0) {
          high--;
        } else {
          ans.add(List.of(nums[i], nums[low++], nums[high--]));
          while (low < high && nums[low-1] == nums[low]) {
            ++low;
          }
        }
      }

      return ans;
    } 
}
