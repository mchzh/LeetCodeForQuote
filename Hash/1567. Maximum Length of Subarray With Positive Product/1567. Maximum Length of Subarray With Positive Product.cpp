class Solution {
public:
    int getMaxLen(vector<int>& nums) {
        int N = nums.size();
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 0) continue;
            int j = i;
            int count = 0;
            int k = -1;
            while (j < N && nums[j] != 0) {
                count += nums[j] < 0;
                if (k == -1 && nums[j] < 0) {
                    k = j;
                }
                if (count % 2 == 0) {
                    ret = max(ret, j-i+1);
                } else if (k != -1) {
                    ret = max(ret, j-k);
                }
                
                j++;
            }
            i = j;
        }
        return ret;
    }
};

//  .... 0 [iX kX Xj] X] 0 ....
//      this range
     
// two pointer

// if {i..j} negative %2 == 0 len = max(len, j-i+1);
// else {k...j} (k is the next index of the first negative number of this subarray)
