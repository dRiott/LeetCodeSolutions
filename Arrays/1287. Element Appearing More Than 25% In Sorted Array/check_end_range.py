class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        quart = len(arr) // 4

        for idx in range(len(arr)-quart):
            if arr[idx] == arr[idx+quart]:
                return arr[idx]

        return -1
