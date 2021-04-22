class Solution {
public:
    int leastBricks(vector<vector<int>>& wall) {
        int n = wall.size();
        unordered_map<int, int> map; // sum -> counter
        for (auto w : wall) {
            int sum = 0;
            for (int i = 0; i < w.size()-1; i++) {
                sum += w[i];
                
                map[sum] +=1;
            }
        }
        
        int rets = n;
        for (auto key : map) {
            rets = min(rets, n-key.second);
        }
        return rets;
    }
};
