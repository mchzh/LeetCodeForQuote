### 1442. Count Triplets That Can Form Two Arrays of Equal XOR

基本思想就是dfs去遍历所有的path。

遍历过程中的处理完全依赖presum思想，在某条路径的过程中用map记录之前出现的sum计数，然后在当前的sum中减去targetsum得到所有符合条件的区间。

思路完全类似560，外包转变化而已，类似思想有很多题，需要总结。

类似题目： [560. Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) /  [325. Maximum Size Subarray Sum Equals k](https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/)

[Leetcode Link](https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/)
