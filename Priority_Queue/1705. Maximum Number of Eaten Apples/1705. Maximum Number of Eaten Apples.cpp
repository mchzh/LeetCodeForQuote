using PII = pair<int, int>; // {date, num}
class Solution {
public:
    int eatenApples(vector<int>& apples, vector<int>& days) {
        int n = apples.size();
        int rets = 0;
        priority_queue<PII, vector<PII>, greater<PII>>pq;
        
        int day = 0;
        while (day < n || !pq.empty()) {
            // eat the earliest rot
            while (!pq.empty() && pq.top().first <= day) { // rotten apple
                pq.pop();
            }
            
            if (day < n && apples[day] != 0) {
                pq.push({day+days[day], apples[day]});
            }
            
            if (!pq.empty()) {
                auto cur = pq.top();
                pq.pop();
                rets++;
                if (cur.second >= 2) {
                    pq.push({cur.first, cur.second-1});
                }
            }
            day++;
        }
        
        return rets;
    }
};
