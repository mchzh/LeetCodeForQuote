### 450. Delete Node in a BST

本题没有太高明的办法，基本递归搜索，但是要利用二分查找树的性质。

对于要删除的节点有三种情况：

1. 删除的是叶子节点；
2. 删除的节点仅有一个孩子；
3. 删除的节点有两个孩子；

对于前两种情况直接删除即可，删除的操作就是让当前节点直接连接其孩子节点，对于最后一种情况是先从其右子树找到最小的点替换val，然后继续删除右子树的最左节点。

``````
if (key < node.val) delete(node.left, key);
else if (key > node.val) delete(node.right, key);
else {
  if (node.left == null) node = node.right;
  else (node.rignt == null) node = node.left;
  else {
    node.val = getMin(node.right);
    delete(ndoe.right, node.val);
  }
}
return node;
```````

[Leetcode Link](https://leetcode.com/problems/delete-node-in-a-bst/)
