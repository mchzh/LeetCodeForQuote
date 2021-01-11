### 1506. Find Root of N-Ary Tree

把每个节点及其直接连接的子节点的值进行异或，题目说值无重复
这样根节点只运算了1次，其余节点运算了2次（异或偶数次抵消了）
最后遍历所有的节点，找到 val 等于异或值的就是根节点。


[Leetcode Link](https://leetcode.com/problems/find-root-of-n-ary-tree/)
