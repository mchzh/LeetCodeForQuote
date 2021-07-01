### 1373. Maximum Sum BST in Binary Tree

依旧按照divide&conquer做法，dfs的过程中先divide，关键处理存什么信息，dfs遍历到每个节点后就存左右节点的信息，之后就判断左右子树的最大值和最小值以及当前节点值的关系。

[Leetcode Link](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)
