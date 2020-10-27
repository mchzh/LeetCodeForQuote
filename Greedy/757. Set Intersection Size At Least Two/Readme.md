### 757. Set Intersection Size At Least Two

我们来分析一下贪心的策略会是什么。

要先从小区间来考虑取什么数，为了尽可能的覆盖后面，所以起始是最右边两个数，rightmost和rightmost-1，当遍历到当前的interval的时候，有三种情形：
`````
1. 完全覆盖现在的两个点，可以不做考虑；
2. 只覆盖了一个点，count加一，说明最右边指针的点是shared的，左指针点移到右指针，右指针尽量移到目前访问区间的最右边；
3. 没有覆盖任何一个点，count加2，左右指针指向新区间的最右边两个点；
`````

区间的排序方式按照end的升序，start的降序排列，保证小区间最早被访问。

[Leecode Link](https://leetcode.com/problems/set-intersection-size-at-least-two/)
