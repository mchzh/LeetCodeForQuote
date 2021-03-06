### 1235.Maximum-Profit-in-Job-Scheduling

将所有的区间按照endTime进行排序是一个很常见的尝试的手段。

假设我们按照如上排序后的顺序，遍历每个区间。我们会想，如果我们选择了第i个区间的话，那么我们就有机会更新这么一个记录```dp[endTime[i]]```，其中dp[t]表示截至t时刻的最大收益。显然，我们会有```dp[endTime[i]] = max(dp[endTime[i]], dp[startTime[i]]+profit[i])```.这像不像DP的思想？

当然，我们不可能在dp里存放每一个时刻的最大收益，我们只能离散化存放每一个endTime时刻的最大收益。也就是说，dp应该是一个哈希表。因此，可能dp记录里并没有startTime[i]，但我们只需要找到第一个小于等于startTime[i]的时刻即可，记为```t```，对应的```dp[t]=val```。特别注意，我们试图记录```dp[endTime[i]] = val+profit[i]```的时候，前提条件是```val + profit[i]```一定要比dp里面最后时刻的收益还要大。也就是说，我们在dp里面只存放按收益递增的```time->profit```键值对。事实上，这也合情合理，如果t0<t1，且dp[t0]>dp[t1]的话，t1并没有必要塞入这个dp数组里面（既浪费了时间反而收益下降）。

于是我们的算法就呼之欲出了。对于当前的区间i，我们在dp数组（或者有序的map）里面考察在startTime[i]时刻之前的最大收益val。假设通过二分法我们得到了它，于是我们就有机会添加```dp[endTime[i]] = val+profit[i]```，但这仅当```t+profit[i]```大于当前dp最后一个时刻的存储值时才操作。

有了这样一个在时间和收益上都是递增的序列dp，我们就可以不断追加```dp[endTime[i]]```的记录，来创建更新的时刻的最大收益。


[Leetcode Link](https://leetcode.com/problems/maximum-profit-in-job-scheduling)
