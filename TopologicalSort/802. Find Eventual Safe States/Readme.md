### 802.Find-Eventual-Safe-States

这是一道经典的涉及有向图是否存在环的问题。DFS和BFS都有经典的解决方案。

#### DFS
用DFS来判定是否有环，可以参考 207.Course-Schedule。基本思想是，将每个节点的visited标记为三种状态。第一次遍历到节点i标记2；如果从节点i后续的DFS都没有检测到环，成功回溯到节点i时，改标记为1.因此在遍历的过程中，遇到了已经标记为1的点，则说明之后肯定“安全”，不用再走下去；如果遇到了已经标记为2的点，则表示该DFS的路线遇到了环。

在本题中，对任意节点i，如果DFS(i)判定无环，则可以放入答案中。

#### BFS
拓扑排序的应用。最容易判定safe的节点，是那些出度为0的节点。将这些点剪除之后，接下来出度为0的节点，肯定还是safe的节点。以此BFS不断推进，如果还有剩下的节点，那么他们肯定出度都不为0，即是互相成环的，可以终止程序。

[Leetcode Link](https://leetcode.com/problems/find-eventual-safe-states/)