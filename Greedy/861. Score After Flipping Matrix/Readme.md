### 861. Score After Flipping Matrix

我们来分析一下贪心的策略会是什么。

Assume A is M * N.

A[i][0] is worth 1 << (N - 1) points, more than the sum of (A[i][1] + .. + A[i][N-1]).
We need to toggle all A[i][0] to 1, here I toggle all lines for A[i][0] = 0.
A[i][j] is worth 1 << (N - 1 - j)
For every col, I count the current number of 1s.
After step 1, A[i][j] becomes 1 if A[i][j] == A[i][0].
if M - cur > cur, we can toggle this column to get more 1s.
max(cur, M - cur) will be the maximum number of 1s that we can get.

[Leecode Link](https://leetcode.com/problems/score-after-flipping-matrix/)
