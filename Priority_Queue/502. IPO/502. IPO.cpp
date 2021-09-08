class Solution {
public:
    int findMaximizedCapital(int k, int w, vector<int>& profits, vector<int>& capital) {
        vector<pair<int, int>>tasks;
        int n = profits.size();
        for (int i = 0; i < n; i++) {
            tasks.push_back({capital[i], profits[i]});
        }
        sort(tasks.begin(), tasks.end());
        
        priority_queue<int>pq;
        int rets = w;
        int count = 0;
        int idx = 0;
        while (count < k) {
            while (idx < n && tasks[idx].first <= rets) {
                pq.push(tasks[idx].second);
                idx++;
            }
            if (pq.empty())  break;
            rets += pq.top();
            pq.pop();
            count++;
        }
        return rets;
    }
};
