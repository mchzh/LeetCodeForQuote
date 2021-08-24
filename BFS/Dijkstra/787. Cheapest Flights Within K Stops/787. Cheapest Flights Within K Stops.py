class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        dp = [math.inf for _ in range(n)]
        dp[src] = 0
        for i in range(k+1):
            dp_temp = dp[:]
            for (a, b, cost) in flights:
                dp[b] = min(dp[b], dp_temp[a] + cost)
        return dp[dst] if dp[dst] != math.inf else -1
