### 1425. Constrained Subsequence Sum

#### 解法1
对于解法2的DP方式进行整理可知：先形成一个初始dp数组，之后就是遍历这个dp数组去得到当前k window size的最大值来更新当前的dp值，已经非常类似239.Sliding-Window-Maximum的思想 -> 我们希望设计这样一个队列，每次读入一个新数nums[i]之后，希望队列弹出的就是当前窗口的最大值。当然，这个最大值不一定要真正“弹出去”，因为可能它处于窗口的中间位置，等下一个新数来的时候，可能依然是读取这个最大值。所以我们希望这个最大值能就一直保持在队列的首端，等待需要的时候再真正清除。什么时候需要清除呢？那就是发现当这个最大值的index等于i-k的时候，说明它超出了窗口长度，不得不踢掉了。

如果把这个最大值踢掉了，我们希望在队列首端的是接下来第二大的值。于是，这就提示了我们：这个队列盛装的是一个递减的序列！这个序列是这个窗口里的最大的几个值的降序排列。这就告诉我们，每进入一个新数nums[i]，这个队列尾端的那些小于nums[i]的都可以踢掉了，然后把新数装进去。这样，直到nums[i]离开窗口之前，函数读取的最大值都是这些比nums[i]大的数。

可以想见，我们需要的数据结构就是一个双端队列dequeu。每次加入新数nums[i]，但从后端弹出一些，以使得里面保持一个递减的序列。每次的队首元素就是当前k窗口的最大值，直到这个队首元素对应的index超出了k窗口的范围才被弹出。

这种解法的时间复杂度是O(N)。

#### 解法2
DP定义：Let dp[i] be the solution for the prefix of the array that ends at index i, if the element at index i is in the subsequence.然后得到递推公式：dp[i] = nums[i] + max(0, dp[i-k], dp[i-k+1], ..., dp[i-1])。这个代码比较好写，但时间复杂度是 o(N2)，超时

````
for (int i = 1; i < N; i++) {
     int j = (i-k >=0) ? i-k : 0;
     for (; j < i; j++) {
         dp[i] = Math.max(dp[i], nums[i]+dp[j]);
     }
     ret = Math.max(ret, dp[i]);
 }
 ````


[Leetcode Link](https://leetcode.com/problems/constrained-subsequence-sum/)
