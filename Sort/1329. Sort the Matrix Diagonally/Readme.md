###1329. Sort the Matrix Diagonally

考虑多种sort解法，遍历每一个对角线用sort方法．

关于bucket排序去复习一下.

[Bucket Sort](https://zhuanlan.zhihu.com/p/46138077)

[Bucket Sort 1](https://www.netjstech.com/2019/01/bucket-sort-program-in-java.html)

For every element, generate the sweep pattern.
[start, 1]
[end, -1]
encounter start plus 1; encounter end minus 1.

[Leetcode Link](https://leetcode.com/problems/sort-the-matrix-diagonally/)
