### 343.Integer-Break

此题最傻的方法是DFS，挨个尝试所有将n拆分为若干数之和的组合形式。

稍微聪明点的可以想到递归。先将n拆分为两个数之和，找出它们乘积最大的一种拆分形式。而每个数又可以递归往下继续拆分为两个数，规模越来越小。所以记忆化搜索或者DP都是比较好写的算法。

最好的想法是利用数学上的技巧。在限定和一定的条件下，我们尽量拆分成接近自然对数e的整数，也就是2或者3，就能使总乘积最大。考虑到以6为例子，3\*3>2\*2\*2，所以我们的目标还是尽量拆成3.所以我们只要计算n除以3的各种情况就行。

1. n能被3整除，则结果就是pow(3,n/3)
2. n被3除余2，则结果就是pow(3,n/3)\*2
3. n被3除余1，稍微有些变化，因为pow(3,n/3)\*1并不合算，我们就退一步，写成pow(3,n/3-1)\*4会得到更大的结果。

类似题目： [1808. Maximize Number of Nice Divisors](https://leetcode.com/problems/maximize-number-of-nice-divisors/)


[Leetcode Link](https://leetcode.com/problems/integer-break)