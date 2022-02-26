class Solution {
public:
    int shortestPathLength(vector<vector<int>>& graph) {
        int n = graph.size();
        int finalState = (1<<n)-1;
        
        queue<pair<int, int>> q;
        vector<vector<bool>>visited(n, vector<bool>(1<<n));
        for (int i = 0; i < n; i++) {
            q.push({i, (1<<i)});
            visited[i][1<<i] = 1;
        }
        
        int step = 0;
        while (!q.empty()) {
            int size = q.size();
            step++;
            
            for (int i = 0; i < size; i++) {
                int curnode = q.front().first;
                int curstate = q.front().second;
                q.pop();
                
                for (int nextnode : graph[curnode]) {
                    int nextstate = (curstate|(1<<nextnode));
                    if (nextstate == finalState) return step;
                    if (visited[nextnode][nextstate] != 1) {
                        q.push({nextnode, nextstate});
                        visited[nextnode][nextstate] = 1;
                    }
                }
            }
        }
        
        return 0;
    }
};
