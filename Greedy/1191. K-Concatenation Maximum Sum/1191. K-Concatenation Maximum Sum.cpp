class Solution {
public:
    int M = 1e9 + 7;
    int kConcatenationMaxSum(vector<int>& arr, int k) {
        if (k == 1) return kadaneSol(arr);
        
        long sum = 0;
        for (auto x : arr) {
            sum = (sum + x)%M;
        }
        
        long ret = 0;
        if (sum > 0) ret = (k-2)*sum % M;
        
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            arr.push_back(arr[i]);
        }
        
        return (kadaneSol(arr)+ret)%M;
    }
    int kadaneSol(vector<int>& arr) {
        int max_total = 0;
        int max_ending_here = 0;
        
        for (auto a : arr) {
            max_ending_here += a;
            max_ending_here %= M;
            
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            max_total = max(max_total, max_ending_here);
        }
        return max_total;
    }
};
