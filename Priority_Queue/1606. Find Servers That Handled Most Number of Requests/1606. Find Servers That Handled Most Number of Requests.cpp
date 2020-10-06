class Solution {
public:
    vector<int> busiestServers(int k, vector<int>& arrival, vector<int>& load) {
        priority_queue<pair<int, int>, vector<pair<int,int>>, greater<pair<int,int>>>busy;
        set<int>free;
        vector<int>count(k, 0);
        
        for (int i = 0; i < k; i++) {
            free.insert(i);
        }
        
        for (int i = 0; i < arrival.size(); i++) {
            while (!busy.empty() && busy.top().first <= arrival[i]) {
                free.insert(busy.top().second);
                busy.pop();
            }
            
            if (free.empty()) continue;
            
            auto iter = free.lower_bound(i%k);
            if (iter == free.end()) {
                iter = free.begin();
            } 
            
            int serverId = *iter;
            free.erase(serverId);
            busy.push({arrival[i]+load[i], serverId});
            count[serverId]++;
        }
        int maxCount = *max_element(count.begin(), count.end());
        vector<int>rets;
        int idx = 0;
        for (int i = 0; i < k; i++) {
            if (count[i] != maxCount) continue;
            rets.push_back(i);
        }
        
        return rets;
    }
};

// free : sorted (set)
// busy : heap 

// emulate procees

// 1. set all elemtn int free;
// 2. tranverse arrival vector;
//     1) check whether busy has released id to free;
//     2) get conrrepindg id from free queue and delete it;
//     3) count the max val for every id;
// 3. according the max val to get the matched id
