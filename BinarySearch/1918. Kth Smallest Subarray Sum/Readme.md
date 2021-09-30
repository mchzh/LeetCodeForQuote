[Subarray Count sum less than target template](https://github.com/mchzh/LeetCodeForQuote/tree/master/Template/SlideWindow/getSubarrayCountSumLessThanTarget)

### 1918. Kth Smallest Subarray Sum

趋势就是看k落在哪个区间内。首先要对于某个给定的sum值求有多少个subarray的和是小于等于这个目标值的，这个需要用到slide window思想。

之后对于每一个目标sum值进行二分法计算，如果子序列和的数目大于等于给定值，说明需要往右找，小于给定值，需要往左多走一步去找。

[Leetcode Link](https://leetcode.com/problems/kth-smallest-subarray-sum/)
