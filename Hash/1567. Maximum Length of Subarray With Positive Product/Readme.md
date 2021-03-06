### 1567.Maximum-Length-of-Subarray-With-Positive-Product

首先，这个subarray里面不能含有0元素。因此我们会将整个数组分拆为若干个被0间隔的区域，每个区域单独处理。

接下来在每一个区域里，我们想要找一段最长的subarray，使得里面包含的负数的个数必须是偶数（可以为0）。假设我们从区域的起点i开始遍历到j的位置，经过的负数有偶数个，那么[i:j]这个subarray就是符合条件的。反之，如果从起点i开始遍历到j的位置时，经过的负数有奇数个，那么我们必然会寻找第一次出现负数的位置（记做k），那么[k+1:j]这个subarray就是符合条件的。总之，如果以j为subarray的右边界，那么左边界只有两种情况：要么就是i，要么就是k+1，取决于到j为止时总共出现了多少次负数。

因为根据j来确定左边界可以用o(1)时间完成，所以本题的时间复杂度是o(N).

[LeetCode Link](https://leetcode.com/problems/maximum-length-of-subarray-with-positive-product/)
