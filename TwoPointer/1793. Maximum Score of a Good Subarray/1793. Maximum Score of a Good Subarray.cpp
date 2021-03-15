class Solution {
public:
    int maximumScore(vector<int>& nums, int k) {
        int n = nums.size();
        int l = k, r = k;
        int minVal = nums[k];
        int rets = 0;
        
        while (l >= 0 || r < n) {
            while (l >= 0 && nums[l] >= minVal) l--;
            while (r < n && nums[r] >= minVal) r++;
            rets = max(rets, minVal*(r-l-1));
            minVal = max(l < 0 ? INT_MIN : nums[l], r >= n ? INT_MIN : nums[r]);
            //cout<<l<<" "<<r<<endl;
        }
    
        return rets;
    }
};
