class Solution {
    unordered_set<int>next[1005];
    int n;
public:
    int findShortestCycle(int n, vector<vector<int>>& edges) {
        this->n = n;

        // create graph
        for (auto&e : edges) {
            int a = e[0], b = e[1];
            next[a].insert(b);
            next[b].insert(a);
        }

        // loop every edge
        int rets = INT_MAX;
        for (auto&e : edges) {
            int a = e[0], b = e[1];
            next[a].erase(b);
            next[b].erase(a);
            rets = min(rets, bfs(a, b));
            next[a].insert(b);
            next[b].insert(a);
        }
        if (rets == INT_MAX) return -1;
        return rets + 1;
    }

    int bfs(int start, int end) {
        vector<int>visited(n);
        queue<int>q;
        q.push(start);
        visited[start] = 1;

        int step = 0;
        while (!q.empty()) {

            int size = q.size();
            while (size--) {
                int cur = q.front();
                q.pop();
                if (cur == end) return step;

                for (auto&nxt : next[cur]) {
                    if (visited[nxt]) continue;
                    q.push(nxt);
                    visited[nxt] = 1;
                }
            }
            step++;
            
        }
        return INT_MAX;
    }
};
