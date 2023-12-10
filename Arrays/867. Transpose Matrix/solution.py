class Solution(object):
    def transpose(self, arr):
        """
        :type matrix: List[List[int]]
        :rtype: List[List[int]]
        """
        # One liner! returns list[list[]]
        # return list(map(list, zip(*arr)))

        n, m = len(arr), len(arr[0])
        ans = [[0] * n for _ in range(m)]
        for r in range(n):
            for c in range(m):
                ans[c][r] = arr[r][c]
        return ans

