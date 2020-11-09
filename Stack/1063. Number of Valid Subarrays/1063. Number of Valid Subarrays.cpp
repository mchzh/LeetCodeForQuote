class Solution {
public:
    int validSubarrays(vector<int>& nums) {
        nums.push_back(INT_MIN);
        int count = 0;
        stack<int> stack;
        
        for (int i = 0; i < nums.size(); i++) {
            while (!stack.empty() && nums[stack.top()] > nums[i]) {
                count += i-stack.top();
                stack.pop();
            }
            stack.push(i);
        }
        return count;
    }
};
