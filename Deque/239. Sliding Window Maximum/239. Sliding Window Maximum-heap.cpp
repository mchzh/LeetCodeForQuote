class Solution {
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        multiset<int>set;
        vector<int>rets;
        
        for (int i = 0; i < nums.size(); i++) {
            set.insert(nums[i]);
            if (set.size() > k)
                set.erase(set.lower_bound(nums[i-k]));
            
            if (set.size() >= k)
                rets.push_back(*set.rbegin());
        }
        return rets;
    }
};
