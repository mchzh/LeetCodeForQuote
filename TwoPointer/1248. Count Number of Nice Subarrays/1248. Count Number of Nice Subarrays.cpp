class Solution {
public:
    int numberOfSubarrays(vector<int>& nums, int k) {
        vector<int>oddidx;
        int n = nums.size();
        oddidx.push_back(-1);
        for (int i = 0; i < n; i++) {
            if (nums[i]%2 == 1) oddidx.push_back(i);
        }
        oddidx.push_back(n);
        
        int rets = 0;
        if (oddidx.size()-1<= k) return rets;

        for (int i = k+1; i < oddidx.size(); i++) {
            rets += (oddidx[i]-oddidx[i-1])*(oddidx[i-k]-oddidx[i-k-1]);
        }
        return rets;
    }
};
