class Solution {
    unordered_map<char, int>count;
    int n;
public:
    int balancedString(string s) {
        
        for (auto ch : s) {
            count[ch] += 1;
        }
        n = s.size();
        bool flag = 1;
        for (auto x : count) 
            if (x.second != n/4) flag = 0;
        
        if (flag == 1) return 0;
        
        // two pointer
        int j = 0;
        int ret = INT_MAX;
        unordered_map<char, int>sum;
        for (int i = 0; i < n; i++) {
            while (j < n && !isOk(sum)) {
                sum[s[j]] += 1;
                j++;
            }
            
            if (isOk(sum)) 
                ret = min(ret, j-i);
            
            sum[s[i]] -= 1;
        }
        return ret;
    }
    bool isOk(unordered_map<char, int>&sum) {
        for (auto x : count) {
            char c = x.first;
            if (count[c] - sum[c] > n/4) return false;
        }
        return true;
    }
};
