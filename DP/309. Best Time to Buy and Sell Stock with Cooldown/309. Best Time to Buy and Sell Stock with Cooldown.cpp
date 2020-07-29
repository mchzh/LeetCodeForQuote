class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold = INT_MIN, sold = 0, cooled = 0;
        for (int i = 0; i < prices.size(); i++) {
            int hold2 = hold, cooled2 = cooled, sold2 = sold;
            int p = prices[i];
            hold  = max(hold2, cooled2-p);
            sold  = hold2+p;
            cooled = max(sold2, cooled2);
        }
        return max(sold, cooled);
    }
};
