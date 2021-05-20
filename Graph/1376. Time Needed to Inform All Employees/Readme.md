### 1376. Time Needed to Inform All Employees

直接思路就是先建图后搜索所有路径，路径带有权重，对每条路径的权重和就是通知时间，求其中最大的时间

```
   graph with adjacent list
   dfs path sum
```

这个方法并不高效，我们应该直接利用递推关系更新现有的time信息来或者最长时间。

这个递推关系可以从下往上考虑，只要当前点有父节点就dfs直到遇到-1，这个时候就更新当前点的路径时间信息同时把该点父节点信息设为-1，表明这个路径已经访问过了。

[LeetCode](https://leetcode.com/problems/time-needed-to-inform-all-employees/)
