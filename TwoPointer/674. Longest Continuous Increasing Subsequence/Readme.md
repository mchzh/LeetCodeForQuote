### 674. Longest Continuous Increasing Subsequence

滑动窗口问题，当移动到的位置元素小于等于上一个元素时，左指针更新到目前位置，否则一直是递增序列，左指针不动，右指针移动，每次都需要算距离来更新最大长度值。


[Leetcode Link](https://leetcode.com/problems/longest-continuous-increasing-subsequence/)
