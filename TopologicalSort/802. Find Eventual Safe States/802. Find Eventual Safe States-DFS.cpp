class Solution {
    // bfs to find out degree
    vector<int>visited;
    vector<vector<int>>graph;
public:
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        int n = graph.size();
        visited.resize(n);
        this->graph = graph;
        
        vector<int>ret;
        for (int i = 0; i < n; i++) {
            if ( DFS(i) == true ) ret.push_back(i);
        }
        return ret;
    }
    
    bool DFS(int cur) {
        if (visited[cur] == 1) return true;
        if (visited[cur] == 2) return false; // has loop
        
        visited[cur] = 2;
        for (int next : graph[cur]) 
            if ( DFS(next) == false ) return false;
        
        visited[cur] = 1; // ensure no loop
        return true;
    }
};

// DFS: visited[i]
// 0: never visited;
// 2: first-time visit unsafe status;
// 1: permanently visited, safe.
