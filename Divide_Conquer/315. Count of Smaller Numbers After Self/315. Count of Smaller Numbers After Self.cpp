class Solution {
    vector<int>rets;
public:
    vector<int> countSmaller(vector<int>& nums) {
        int n = nums.size();
        rets.resize(n);
        auto sorted = nums;
        helper(nums, sorted, 0, n-1);
        return rets;
    }
    void helper(vector<int>& nums, vector<int>& sorted, int a, int b) {
        // corner case
        if (a >= b) return;
        // divide
        int mid = a + (b-a)/2;
        helper(nums, sorted, a, mid);
        helper(nums, sorted, mid+1, b);
        
        // conquer
        for (int i = a; i <= mid; i++) {
            auto iter = lower_bound(sorted.begin()+mid+1, sorted.begin()+b+1, nums[i]); // left close and right open
            rets[i] += iter-(sorted.begin()+mid+1);
        }
        // merge sort
        int temp[b-a+1];
        int i = a, j = mid+1, p = 0;
        while (i <= mid  && j <= b) {
            if (sorted[i] < sorted[j]) {
                temp[p] = sorted[i];
                i++;
                p++;
            } else {
                temp[p] = sorted[j];
                j++;
                p++;
            }
        }
        while (i <= mid) {
            temp[p] = sorted[i];
            i++;
            p++;
        }
        while (j <= b) {
            temp[p] = sorted[j];
            j++;
            p++;
        }
        for (int x = a; x <= b; x++) {
            sorted[x] = temp[x-a];
        }
    }
};
