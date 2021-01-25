### 1151. Minimum Swaps to Group All 1's Together

基本的贪心思想就是1会聚集到一起，所以1的总的大小就是需要遍历的滑窗大小。

对每一个滑窗里统计所有0的个数就是需要swap的1的次数，滑窗到结尾每次update最小值。

[Leecode Link](https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together/)
