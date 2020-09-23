### 449. Serialize and Deserialize BST

此题有多种解法，我认为对于此题和一般Tree的Serilize and Deserialize区别在于空间复杂度的减低，因为不需要存储更多表示null的特殊符号，通过遍历可以确定左右子树的边界。

相较于一般tree，理论上此题的时间复杂度还要高于它，因为每次去dfs之前需要遍历一下来区分左右子树，不过大体上应该都是O(N)。

在处理recursion的时候，左右子树边界的确定类似于这三个题目：

[889	Construct Binary Tree from Preorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/)

[106	Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

[105	Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)
```
(node, left, right)
fins rightStart (if -1, means no right subtree)
left: (left, rightStart == -1 ? -1 : rightStart-1)
right: (rightStart, rightStart == -1 ? -2 : right)
```

[Leetcode Link](https://leetcode.com/problems/serialize-and-deserialize-bst/)
