### 1319. Number of Operations to Make Network Connected

#### 解法１：　Union Find
When connect 两个数尝试进行Union。

每次connect之后要把group数目减一，遇到重复的union需要记录重复了多少条边。核心思想是union的时候处理额外group和edge的信息。


[Leetcode Link](https://leetcode.com/problems/number-of-operations-to-make-network-connected/)
