class Solution {
public:
    int shareCandies(vector<int>& candies, int k) {
        
        int n = candies.size();
        vector<int>count(100005, 0);
        int uniquetotal = 0;
        for (int i = 0; i < n; i++) {
            int cur = candies[i];
            count[cur]++;
            if (count[cur] == 1) uniquetotal++;
        }
        if (k == 0) return uniquetotal;
        
        int rets = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            int cur = candies[i];
            if (i > k-1) {
                int remedy = candies[left];
                count[remedy]++;
                if (count[remedy] == 1) uniquetotal++;
                left++;
            }
            
            count[cur]--;
            if (count[cur] == 0) uniquetotal--;
            if (i >= k-1) rets = max(rets, uniquetotal);
        }
        return rets;
    }
};
