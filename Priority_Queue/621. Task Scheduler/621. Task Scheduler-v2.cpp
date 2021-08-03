class Solution {
public:
    int leastInterval(vector<char>& tasks, int n) {
        n++;
        vector<int>count(26);
        for (auto t : tasks) count[t-'A']++;
        
        int maxFreq = 0;
        for (auto c : count) maxFreq = max(c, maxFreq);
        
        int tail = 0;
        for (auto c : count) if (c == maxFreq) tail++;
        
        // (maxFreq-1)*n+tail : tasks.size()
        return max( (maxFreq-1)*n+tail, (int)tasks.size());
    }
};
