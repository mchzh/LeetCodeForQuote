class Solution {
public:
    bool xorGame(vector<int>& nums) {
        int xorsum = 0;
        for (int n : nums) xorsum ^= n;
        if (xorsum == 0) return true;
        return nums.size()%2 == 0;
    }
};
