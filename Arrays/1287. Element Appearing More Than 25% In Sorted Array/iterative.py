class Solution:
    def findSpecialInteger(self, arr: List[int]) -> int:
        count = len(arr) / 4

        prev = None
        num = 0
        for val in arr:
            if val != prev:
                num = 0
                prev = val

            num+=1
            if num > count:
                    return val    


        return -1
