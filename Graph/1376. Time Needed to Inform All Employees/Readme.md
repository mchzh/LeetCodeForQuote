### 1376. Time Needed to Inform All Employees

直接思路就是先建图后搜索所有路径，路径带有权重，对每条路径的权重和就是通知时间，求其中最大的时间

```
   graph with adjacent list
   dfs path sum
```

这个方法并不高效，我们应该直接利用递推关系更新现有的time信息来或者最长时间。

[LeetCode](https://leetcode.com/problems/time-needed-to-inform-all-employees/)
