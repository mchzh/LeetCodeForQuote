class Solution:
    def maxPower(self, stations: List[int], r: int, k: int) -> int:
        n = len(stations)
        left, right = 0, 10**18
        while left < right:
            mid = right - (right - left) // 2

            if self.isOK(stations, r, k, mid):
                left = mid
            else:
                right = mid -1
        return left
    
    def isOK(self, stations: List[int], r: int, k: int, mid: int) -> bool:
        n = len(stations)
        sum = 0
        arr = stations[:]

        for i in range(min(r, n)):
            sum += arr[i]

        for i in range(n):
            if i+r < n:
                sum += arr[i+r]
            if i-r-1 >= 0:
                sum -= arr[i-r-1]

            if sum >= mid:
                continue
            d = mid - sum
            if k < d: 
                return False
            pos = min(n - 1, i + r)
            arr[pos] += d
            sum = mid
            k -= d
        
        return True
