class Solution {
public:
    int findMinMoves(vector<int>& machines) {
        int n = machines.size();
        int sum = 0;
        for (int m : machines) sum += m;

        if (sum%n != 0) return -1;
        int k = sum/n;

        vector<int>left(n, 0);
        vector<int>right(n, 0);
        left[n-1] = machines[n-1] - k;
        right[0] = machines[0] - k;

        for (int i = 1; i < n-1; i++) {
            left[i] = -right[i-1];
            right[i] = machines[i] - k - left[i];
        }

        int rets = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (left[i] >= 0) cur += left[i];
            if (right[i] >= 0) cur += right[i];
            rets = max(rets, cur);
        }
        return rets;
    }
};
