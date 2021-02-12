### 1423. Maximum Points You Can Obtain from Cards

此题可以转换为求有最小和的subarray而且这个subarray有固定的大小。

Let the sum of all points be total_pts. You need to remove a sub-array from cardPoints with length n - k.

Keep a window of size n - k over the array. The answer is max(answer, total_pts - sumOfCurrentWindow)

[Leetcode Link](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/)
