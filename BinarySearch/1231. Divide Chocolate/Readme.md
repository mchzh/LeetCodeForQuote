### 1231.Divide-Chocolate

很容易感觉出来，如果 minimum total sweetness 的要求越低，那么就越容易实现。极端的例子就是取数组中的最小元素为要求的甜度，那么无论怎么切，每一份的甜度都肯定是大于最小元素值的。反之，如果 minimum total sweetness 的要求越高，那么就越不容易实现。于是这就是典型的二分搜值的应用场景。只要猜测一个给定甜度值t，查验在数组中是否至少能拆分出k+1个subarray的和大于t。可以的话，那么可以猜更大的t，反之就猜测更小的t。

[Leetcode Link](https://leetcode.com/problems/divide-chocolate/)
