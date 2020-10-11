### 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree

依旧按照divide&conquer做法，dfs的过程中先divide，关键处理存什么信息，dfs遍历到target就返回cloned node，如果不是就同时继续走原树和clone树的左子树和右子树。

[Leetcode Link](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)
