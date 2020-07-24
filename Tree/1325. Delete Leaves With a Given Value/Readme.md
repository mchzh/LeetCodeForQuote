### 1325. Delete Leaves With a Given Value

本题表面上是关于图、关于树，本质上我觉得更像BFS，或者说树的level order traversal.

典型的divide&conquer做法，dfs的过程中先divide，然后统一在conquer过程中处理该访问点： 两种情况一种返回null，另一种链接左右子树返回本身。

[Leetcode Link](https://leetcode.com/problems/delete-leaves-with-a-given-value/)
