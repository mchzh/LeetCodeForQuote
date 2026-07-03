### 3620. Network Recovery Pathways
Approach 1: Binary Answer + Shortest Path (Dijkstra)
Intuition
Let's first summarize the key observations from the problem:

We are given a directed graph, where the online status of each node is determined by the array online.
An edge is considered valid only if both of its endpoints are online.
We need to find a path from node 0 to node n−1 whose total edge weight does not exceed k, and every node on the path must be online.
The score of a path is defined as the minimum edge weight along that path. Our goal is to maximize this score.
If no valid path exists, return −1.
Problems that ask us to maximize the minimum value often exhibit a monotonic property, making binary search a natural solution.

Suppose there exists a path from node 0 to node n−1 such that

its total weight is at most k, and
its minimum edge weight is at least x.
Then, for any threshold y≤x, the same path also satisfies

its total weight is still at most k, and
every edge weight is at least y.
Therefore,

if check(x) is feasible, then check(y) is also feasible for every y≤x;
if check(x) is infeasible, then check(z) is also infeasible for every z>x.
This monotonicity allows us to binary search the answer.

For each candidate value mid, we check whether a valid path exists under the following restriction:

Only edges whose weights are at least mid may be used.
The total weight of the path must not exceed k.
If check(mid) returns true, then a path exists whose minimum edge weight is at least mid, so we try a larger threshold.

Otherwise, no such path exists, and we decrease the threshold.

The remaining question is how to implement check(). In this approach, we use Dijkstra's algorithm.

The procedure is straightforward:

Build the graph using only edges whose endpoints are both online.
For each candidate threshold mid:
Ignore every edge whose weight is smaller than mid.
Run Dijkstra's algorithm to compute the shortest path from node 0 to node n−1.
If the shortest distance is at most k, then mid is feasible.
