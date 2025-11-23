class Solution:
    def maxSumDivThree(self, nums: List[int]) -> int:
        n = len(nums)
        div = 3
        dp = [0, -math.inf, -math.inf]
        
        for i in range(n):
            a = nums[i]
            k = a%3
            olddp = dp[:]
            for j in range(div): 
                dp[j] = max(olddp[j], olddp[(j-k+3)%3] + a)

        return dp[0]
