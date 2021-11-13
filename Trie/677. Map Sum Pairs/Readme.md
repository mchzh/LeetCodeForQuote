### 677. Map Sum Pairs

此题是用将map与Trie的数据结构相结合。依然用到了trie的insert和search基本功能，辅以map去确定当前word的值，然后在trie的insert遍历过程中增加这个变化的值。

进一步思考trie中的数目减少或者如何删除一个node，删除其实就是将其赋值为0.

[Leetcode Link](https://leetcode.com/problems/map-sum-pairs/)
