class Solution {
public:
    int maxScore(vector<int>& cardPoints, int k) {
        int n = cardPoints.size();
        int distance = n-k;
        int presum[n+1];
        int total = 0;
        int rets = INT_MAX;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
            presum[i+1] = presum[i] + cardPoints[i];
        }
        
        for (int i = 0;i <= k; i++) {
            rets = min(rets, presum[i+distance] - presum[i]);
        }
        
        return total - rets;
    }
};
