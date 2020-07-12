class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        // from the beging of a chain to retrive this sequence
        unordered_set<int>Set(nums.begin(), nums.end());
        
        int ret = 0;
        for (auto x : nums) {
            int count = 0;
            if (Set.find(x-1) == Set.end()) { // this is a begin point for a increasing subsequence
                while (Set.find(x) != Set.end()) {
                    count++;
                    x++;
                }
            }
            ret = max(ret, count);
        }
        return ret;
    }
};
//YYYYXYYYYY
