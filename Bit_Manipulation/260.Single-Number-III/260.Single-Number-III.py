class Solution:
    def singleNumber(self, nums: List[int]) -> List[int]:
        s = 0
        for a in nums:
            s ^= a
        compare = s^(s&(s-1))
        a = 0
        b = 0
        # print(b)       
        for x in nums:
            if x&compare:
                # conditon
                a ^= x
            else:
                b ^= x
        return [a, b]
