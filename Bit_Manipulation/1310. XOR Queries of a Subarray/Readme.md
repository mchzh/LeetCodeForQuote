### 1310. XOR Queries of a Subarray

我们知道，XOR的最常用的一个性质就是x^x=0，我们需要尽量使用这个性质。同时我们联想presum，对于xor所有元素都xor一下，组成一个一个chain，对于当前的xor chain用数组记录```nums[0]^..^nums[i]```.

对于quiery，我们就用两个index元素的数组xor就能得到区间xor。

[LeetcodeLink](https://leetcode.com/problems/xor-queries-of-a-subarray/)
