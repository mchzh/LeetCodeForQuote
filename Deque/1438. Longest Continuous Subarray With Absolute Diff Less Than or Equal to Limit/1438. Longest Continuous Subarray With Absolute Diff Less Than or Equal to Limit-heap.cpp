class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        multiset<int>Set({nums[0]});
        int rets = 0;
        
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            while (*Set.rbegin()-*Set.begin() <= limit) {
                rets = max(rets, j-i+1);
                j++;
                if (j < nums.size()) Set.insert(nums[j]);
                else break;
            }
            
            if (j == nums.size()) break;
            
            Set.erase(Set.find(nums[i])); // remove the left most element
        }
        return rets;
    }
};
