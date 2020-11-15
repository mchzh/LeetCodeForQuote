### 207. Course Schedule

本题是典型拓扑排序，先用邻接表建立有向图， 然后BFS去遍历这个图，最后用计数器判断是否完全能安排课程.

BFS的本质就是从入度为零的node开始一层层剥洋葱，过程中新产生的入度为0的都加入到队列中，最后就可以看到是不是能完成所有课，拓扑排序中判断有环用dfs比较方便。

dfs关键就是控制被访问的点的状态：
、、、
        if (visited[cur] == 1) return true;

        visited[cur] = 2;
        if (graph.containsKey(cur)) {
            for (int next : graph.get(cur)) {
                if (visited[next] == 1) continue;
                if (visited[next] == 2) return false;
                if (dfs(next) == false) return false;
            }
        }

        visited[cur] = 1
        return true;
、、、、

[Leetcode Link](https://leetcode.com/problems/course-schedule/)
