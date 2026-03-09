Intuition
A stable array cannot contain more than limit equal elements consecutively.
So the problem becomes: count all binary arrays with exactly zero zeros and one ones such that no block of consecutive 0s or 1s is longer than limit.

To count them efficiently, use DP based on the last element:

dp0[i][j] = number of valid arrays using i zeros and j ones, ending in 0

dp1[i][j] = number of valid arrays using i zeros and j ones, ending in 1

Instead of recomputing the full sum of previous valid block sizes every time, we use an optimized sliding-window style recurrence to get each state in O(1).

Approach
We build the answer with dynamic programming.


DP definition

dp0[i][j]: valid arrays with i zeros and j ones that end with 0

dp1[i][j]: valid arrays with i zeros and j ones that end with 1
Base cases

If the array contains only zeros, there is exactly one possible arrangement:

dp0[i][0] = 1 for 1 <= i <= limit

Similarly, if the array contains only ones:

dp1[0][j] = 1 for 1 <= j <= limit
If the count exceeds limit, that arrangement is invalid.

Transition

To compute dp0[i][j], we append a 0 to arrays with i-1 zeros and j ones.
That gives:

dp0[i-1][j] + dp1[i-1][j]

But this may create a run of 0s longer than limit, so we subtract the invalid cases:

dp1[i-limit-1][j]

Thus:

dp0[i][j]=dp0[i−1][j]+dp1[i−1][j]−dp1[i−limit−1][j]
Similiarly:

dp1[i][j]=dp0[i][j−1]+dp1[i][j−1]−dp0[i][j−limit−1]
All operations are done modulo 1e9+7.

Finally, the answer is:

dp0[zero][one]+dp1[zero][one]
