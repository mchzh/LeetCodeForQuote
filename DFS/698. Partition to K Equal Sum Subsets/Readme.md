### 698.Partition-to-K-Equal-Sum-Subsets

此题据说是NP-hard，没有什么特别高明的算法，就是老老实实地DFS，尝试将所有元素挨个尝试放入k个分类里，直至找到满足条件的分类。

设计如下的递归函数：```DFS(nums, curPos, curGroup, curSum, SUM, visited)```.
注意边界条件的转换：
```cpp
        if (curGroup==k) return true;
        if (curSum==SUM) return DFS(nums,0,curGroup+1,0,SUM,visited);
        if (curSum>SUM) return false;
        if (curPos==nums.size()) return false;
        ///
        if (DFS(nums,i+1,curGroup,curSum+nums[i],SUM,visited))
          return true;
        ///
```        

另外，如果提前将所有元素从大到小排序，则有额外的优化效果：从大元素开始尝试的话，则可以迅速排除一些因为元素过大造成的negative测例。

其次，每深入一次递归，只需要从curPos及其之后开始考察，不需要从头开始选取。

第三，一个重要的剪枝手段：
```cpp
if (curPos!=i && nums[i]==nums[i-1] && visited[i-1]==0)
    continue;
```
这是因为若nums[i-1]已经被搜索过并且失败后回溯的话，相同的nums[i]就不需要再次被搜索了，注定是失败的。注意，```visited[i-1]==0```保证了nums[i-1]一定是在同级的搜索中已经尝试过的，缺少了这个判定条件则会误剪这个分支。

与本题非常相似的题目有： 473. Matchsticks to Square, 416. Partition Equal Subset Sum, 996. Number of Squareful Arrays    


[Leetcode Link](https://leetcode.com/problems/partition-to-k-equal-sum-subsets)
