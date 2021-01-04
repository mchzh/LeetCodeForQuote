class Solution {
public:
    int waysToSplit(vector<int>& nums) {
        int n = nums.size();
        vector<long long>presum(n, 0);
        presum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            presum[i] = presum[i-1] + nums[i];
        }
        
        int j = 0;
        long long rets = 0;
        long long M = 1e9+7;
        for (int i = 0; i < n ; i++) {
            while (j <= i || (j<n && presum[j]-presum[i] < presum[i]) ) {
                j++;
            }
            if (j == n) break;
            
            auto iter = upper_bound(presum.begin(), presum.end(), 0.5*(presum[i] + presum[n-1])) - 1;
            
            
            int k = iter-presum.begin();
            //cout<<(*iter)<<" "<<j<<" "<<(*presum.begin())<<" "<<k<<endl;
            if (k < j) continue;
            if (k == n-1) k--;
            
            rets += k-j+1;
            rets %= M;
        }
        return rets;
    }
};
