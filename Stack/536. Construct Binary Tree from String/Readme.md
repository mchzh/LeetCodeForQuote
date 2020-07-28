### 536. Construct Binary Tree from String

此题粗看很复杂，实际很明晰。

重点是确定如何进栈和出栈，栈里面应该保存parent treenode信息，当遇到‘)’时创建当前node，然后加入到parent的left或者right sub node。

具体的算法是，当发现?字符，表明这可能是一组标准型的head。所以把a?之前的字符串扔进栈里，然后重置curRes并顺着a?继续向后探索。如果还有出现类似?的标记，则重复之前的入栈操作；反之，如果之后curRes集齐五个字符，则说明这五个字符是类似a?X:Y的标准型，可以被解析变为一个字符。此时考虑一下栈里的栈顶元素，如果栈顶元素加上当前的这一个字符（curRes），又构成五个字符的话，可以进一步解析；如此重复直至栈顶无法提供凑齐五个字符的string，此时curRes需要顺着expression继续探索下去。

最终返回的是当前的字符串，即curRes。


[Leetcode Link](https://leetcode.com/problems/construct-binary-tree-from-string/)
