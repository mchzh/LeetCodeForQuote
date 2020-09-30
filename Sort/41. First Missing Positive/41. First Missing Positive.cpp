class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        nums.insert(nums.begin(), 0);
        
        for (int i = 0; i < nums.size(); i++) {
            while ( !(nums[i] == i || nums[i] < 0 || nums[i] >= nums.size()
                      || nums[i] == nums[nums[i]]) ) {
                // swap
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i]; 
                nums[i] = temp;
            }
            
        }
        
        for (int i = 1; i < nums.size(); i++) {
            if ( i!= nums[i] ) return i;
        }
        return nums.size();
    }
};
