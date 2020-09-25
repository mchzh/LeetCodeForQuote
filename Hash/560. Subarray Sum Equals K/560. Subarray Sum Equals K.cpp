class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int ret = 0;
        unordered_map<int, int>map; // key(sum) -> count;
        map[0] = 1;
        int preSum = 0;
        for (int i = 0; i < nums.size(); i++) {
            preSum += nums[i];
            if (map.find(preSum-k) != map.end()) {
                ret += map[preSum-k];
            }
            map[preSum]++;
        }
        return ret;
    }
};
