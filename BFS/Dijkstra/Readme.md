和Floyd算法一起考虑， Dijkstra算法只针对positive weight，且是SSSP（single source shortestpath），同时Bellman-Ford算法也是sssp但是可以是negative weight。

Djikstra used this property in the opposite direction i.e we overestimate the distance of each vertex from the starting vertex. Then we visit each node and its neighbors to find the shortest subpath to those neighbors.

The algorithm uses a greedy approach in the sense that we find the next best solution hoping that the end result is the best solution for the whole problem.

[Dijkstra Explanation](https://www.programiz.com/dsa/dijkstra-algorithm)
