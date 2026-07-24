class Solution {
public:
    int rob(vector<int>& nums) {
       if (nums.size() == 0) return 0;

       int rob = nums[0], nonrob = 0;
       for (int i = 1; i < nums.size(); i++) {
        int rob_tmp = rob, nonrob_tmp = nonrob;
        nonrob = max(rob_tmp, nonrob_tmp);
        rob = nonrob_tmp + nums[i];
       }
       return max(rob, nonrob);
    }
};
