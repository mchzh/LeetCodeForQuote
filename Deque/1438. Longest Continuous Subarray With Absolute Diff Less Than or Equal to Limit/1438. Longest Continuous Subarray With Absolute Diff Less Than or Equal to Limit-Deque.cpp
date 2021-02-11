class Solution {
public:
    int longestSubarray(vector<int>& nums, int limit) {
        deque<int>qmax({0});
        deque<int>qmin({0});
        int rets = 0;
        int mx = nums[0], mn = nums[0];
        
        int j = 0;
        for (int i = 0; i < nums.size(); i++) {
            while (mx - mn <= limit) {
                rets = max(rets, j-i+1);
                j++;
                if (j == nums.size()) break;
                
                // update deque max and min
                while (qmax.size() > 0 && nums[j] >= nums[qmax.back()]) qmax.pop_back();
                qmax.push_back(j);
                mx = nums[qmax.front()];
                
                while (qmin.size() > 0 && nums[j] <= nums[qmin.back()]) qmin.pop_back();
                qmin.push_back(j);
                mn = nums[qmin.front()];  
            }
            
            if (j == nums.size()) break;
            
            //Set.erase(Set.find(nums[i])); // remove the left most element
            if (qmax.size() > 0 && qmax.front() == i) {
                qmax.pop_front();
                mx = nums[qmax.front()];
            }
            if (qmin.size() > 0 && qmin.front() == i) {
                qmin.pop_front();
                mn = nums[qmin.front()];
            }
        }
        return rets;
    }
};
