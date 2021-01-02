### 1442. Count Triplets That Can Form Two Arrays of Equal XOR

第一步就是类似presum求出prefix xor，任意区间内的xor值就是p[j]^p[i]。

然后就是两重循环O（n2）去得到xor值为0的区间，区间长度减一就是这个区间能够形成的triplet个数。

[Leetcode Link](https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/)
