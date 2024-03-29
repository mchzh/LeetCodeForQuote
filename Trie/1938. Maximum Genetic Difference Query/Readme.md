### 1938.Maximum-Genetic-Difference-Query

本题的题意是：给出一棵树。对于query(node, val)，我们需要在从node到root的路径中，找一个节点的nodeVal，使得val^nodeVal的结果最大。

在一堆数nums里面挑一个数，使得其与指定的一个数a的XOR值最大，是一个老题，参见```421.Maximum-XOR-of-Two-Numbers-in-an-Array```。具体的做法是将nums里面的数都写成32位的二进制串，然后拼接成一棵前缀树。基于a的二进制表达式，我们尽量沿着二叉树向下走，每一位都尽量相对于a取反。这样一路走下来得到的数b，就是a^b最大的结果。

对于本题，因为query的数量太多，显然我们不会对每个query都重新建一棵Trie。我们发现，对于同一个路径上的节点A->B->C...，它们的Trie只会彼此相差一条支链。这让我们想到了从上往下的DFS。从根节点按深度优先遍历所有的支路，每深入一个节点，就把该节点的值加入Trie（即Trie增加了一条新支链），这样就最大程度地利用了已有的Trie。这样对于query(A,val), query(B,val), query(C,val) .... 这些结果，都可以在DFS的过程中一并得到解决。

但是DFS有一个很重要的步骤就是回溯。当我们结束A->B->C这条路径的探索，想要转而探索A->B->D的话，那么我们就需要在原有的Trie里删去C元素所对应的支链。那么如何高效地删除一条支链呢？显然不应该把C的所有bit位对应的节点都从Trie里删除，因为它们可能是与其他支链共享的。其次，物理上删除一个节点释放空间也很耗时。我们的解决技巧是：对于Trie里的每个节点都添加cnt属性。如果这个节点被Trie的一条支链使用了，那么就将它的cnt增一。如果我们想要删除一个支链，那么就将这条支链上的所有节点的cnt都减一。如果某个TrieNode的cnt为零，那么就可以认为该节点（及其子孙节点）都被删除了。这个技巧我们在```212.Word-Search-II```里已经用到过。

注意，因为cnt的引入，我们在遍历Trie的时候，不应该去访问那些cnt为零的节点。

[1707 explanation link](https://github.com/mchzh/LeetCodeForQuote/tree/master/Trie/1707.%20Maximum%20XOR%20With%20an%20Element%20From%20Array)
