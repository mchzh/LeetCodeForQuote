### 1305. All Elements in Two Binary Search Trees

此题的代码几乎和 94. Binary Tree Inorder Traversal 完全一致。基本就是94的增强版，需要两个stack来维护两个树的iterator顺序，唯一的区别就是记录元素的时机。先序遍历（preorder）是首先记录根节点，所以在入栈的时候就需要读数（读完根节点，再递归左子树）。而中序遍历（inorder）是先记录左子树，所以需要先一路入栈到最底层，在退栈的时候再开始依次读数。
```cpp
        while (root!=NULL || !Stack.empty())
        {
            if (root!=NULL)
            {
                results.push_back(root->val); // 中序遍历在此读数
                Stack.push(root);
                root=root->left;
            }
            else
            {
                root=Stack.top();
                results.push_back(root->val); // 先序遍历在此读数
                Stack.pop();
                root=root->right;
            }
        }
```        


[Leetcode Link](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/)
