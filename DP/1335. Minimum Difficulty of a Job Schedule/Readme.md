### 1335.Minimum-Difficulty-of-a-Job-Schedule

本题翻译成人话就是：将数组分成d个subarray，最小化“每个subarray最大值的和”。

因为题意明确要求分成若干个subarray，这非常强烈地暗示了这是我所归纳的第一类区间型DP解法。具体的状态定义就是dp[i][k]代表将前i个工作分配在k天内完成的最优
解（即最小化“每个subarray最大值的和”）。状态转移的核心就是判断最后一个subarray的起始点在哪里，找到最优的下标j，使得dp[i][k]分解为dp[j-1][k-1]和arr[j:i]两个子问题，然后相加。

本题中，处理arr[j:i]所需要做的就是找到其中的最大值。所以我们将j从后往前搜索比较方便，可以顺便将这个arr[j:i]区间内的最大值给一路更新了。

整体的时间复杂度就是o(NND).

[LeetCode Link](https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/)
