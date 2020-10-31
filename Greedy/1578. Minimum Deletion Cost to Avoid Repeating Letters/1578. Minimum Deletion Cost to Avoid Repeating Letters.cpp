class Solution {
public:
    int minCost(string s, vector<int>& cost) {
        int i = 0, j = 0, n = s.size();
        int curmax = 0, sum = 0;
        int rets = 0;
        while (j < n) {
            if (s[j] != s[i]) {
                i = j;
                rets += sum-curmax;
                sum = 0;
                curmax = 0;
            }
            sum += cost[j];
            curmax = max(curmax, cost[j]);
            j++;
        }
        if (j-1 > i) {
            rets += sum-curmax;
        } 
        return rets;
    }
};
