class Solution {
public:
    int minJumps(vector<int>& arr) {
        int N = arr.size();
        if (N == 1) return 0;
        unordered_map<int, vector<int>>map;
        for (int i = 0; i < N; i++) {
            map[arr[i]].push_back(i);
        }
        
        queue<int>q;
        q.push(0);
        vector<int>visited(N, 0);
        visited[0] = 1;
        
        int step = 0;
        while(!q.empty()) {
            int len = q.size();
            while (len--) {
                int cur = q.front();
                q.pop();
                
                // +1 -1
                if (cur+1 < N && visited[cur+1] == 0) {
                    q.push(cur+1);
                    visited[cur+1] = 1;
                }
                if (cur-1 >= 0 && visited[cur-1] == 0) {
                    q.push(cur-1);
                    visited[cur-1] = 1;
                }
                
                // same val with the current idx element
                // include same val
                for (int next : map[arr[cur]]) {
                    if (visited[next] == 1) continue;
                    q.push(next);
                    visited[next] = 1;
                }
                map.erase(arr[cur]);
            }
            step++;
            if (visited[N-1] == 1) return step;
        }
        
        return -1;
    }
};

// {1,1,1,1,1,1,....1}
