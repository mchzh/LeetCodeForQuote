### 1198. Find Smallest Common Element in All Rows

因为需要找公共出现的一个数，而且每个行的数据都是递增的，对于递增趋势就可以考虑二分法。

由于需要找到最小公共数，所以就可以外层遍历第一行的所有数字，然后对于其他行的数据进行二分搜值，如果所有行都有这个指定的数字就找到了，否则继续遍历寻找。

[Leetcode Link](https://leetcode.com/problems/find-smallest-common-element-in-all-rows/)
