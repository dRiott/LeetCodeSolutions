class SortedTwoSum(object):
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        nums.sort();
        res = []
        for i in range(len(nums)):
          if (i == 0 or nums[i-1] != nums[i]):
            self.twoSum(nums, i, res)
        return res

    def twoSum(self, nums, i, res):
      lo, hi = i+1, len(nums)-1
      while (lo < hi):
        sum = nums[i] + nums[lo] + nums[hi]
        if sum < 0:
            lo+=1
        elif sum > 0:
            hi-=1
        else:
            res.append([nums[i], nums[lo], nums[hi]])
            lo += 1
            hi -= 1
            while lo < hi and nums[lo] == nums[lo-1]:
                lo+=1
