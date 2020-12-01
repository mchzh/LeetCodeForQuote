### 1296. Divide Array in Sets of K Consecutive Numbers

先用map记录频率关系，然后用heap去访问起始点，在起始点去判断k个连续的数，而且这k个连续数的出现次数要多于起始点的频率，访问后每个数要把频率减去起始点的频率然后更新。

与本题类似的题目还有：846. Hand of Straights


[Leetcode Link](https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/)
