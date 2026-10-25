### 3883. Count Non Decreasing Arrays With Given Digit Sums

本题最重要的就是这个结论：所有的机器人排序后所对应的工厂顺序，一定就是工厂的位置顺序。也就是说，任意两个机器人i<j，如果他们对应的工厂是x和y，那么一定有x<y。如果i与y配对、j与x配对，那么显然不会比i与x配对、j与y配对更优。我们只要穷举i,j,x,y四者之间的位置关系，就不难得出这个结论。

于是本题就是一个非常典型的第一类区间型DP。我们令dp[i][j]表示前i个工厂覆盖了前j个机器人时，所需要的最小路径和。显然，对于状态转移方程，我们关心的就是最后一个工厂的覆盖范围，我们遍历一下最后一个工厂所覆盖的机器人数目即可:
```cpp
for (int k=0; k<=factory[i][1]; k++) {
    dp[i][j] = min(dp[i][j], dp[i-1][j-k] + dist[i][j-k+1][j]);
}
```
其中`dist[i][j-k+1][k]`表示最后k个机器人都送到第i个工厂时，所对应的总路程。

可见，对于dp[i][j]的计算需要三重循环，恰好是1e6复杂度。对于dist，我们需要提前预处理，也正好是三重循环，1e6复杂度。

dp[i][x]：在位置i上数据元素值是x的情况下唯一表达的数组数目
State transition
Suppose we are processing index \(i\), and we want to calculate dp[i][x].

For this to be valid, two things must be true:
- \(S(x)=digitSum[i]\).
- The previous element must be less than or equal to \(x\), because the array is non-decreasing.
Let the previous element be \(y\). We can choose any \(y\) satisfying \(0\le y\le x\).

For every such \(y\), there are \(dp_{i-1}[y]\) valid prefixes ending at \(y\). Appending \(x\) to each prefix produces valid arrays ending at \(x\).

Therefore, the recurrence is:
\[
\boxed{
dp_i[x]=
\begin{cases}
\displaystyle\sum_{y=0}^{x}dp_{i-1}[y]
& S(x)=digitSum[i]\\[6pt]
0 & \text{otherwise}
\end{cases}
}
\]

This is the core DP formula.
Why do we sum all previous values from 0 to x?
Suppose the previous index can end with values 1, 3, and 5, and we want to append 5.

All three are allowed because:
- [1, 5] is non-decreasing.
- [3, 5] is non-decreasing.
- [5, 5] is non-decreasing.
But if we want to append 3, only previous values less than or equal to 3 are allowed. A previous value of 5 cannot be followed by 3.

The condition is previous <= current, not previous < current, because equal adjacent values are allowed.
