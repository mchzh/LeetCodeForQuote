class Solution {
public:
    int maxSatisfied(vector<int>& customers, vector<int>& grumpy, int X) {
        // slide window
        int N = customers.size();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (grumpy[i] == 0) sum += customers[i];
        }
        
        // right point
        int ret = 0;
        for (int i = 0; i < N; i++) {
            if (grumpy[i] == 1) sum += customers[i];
            if (i-X >= 0 && grumpy[i-X] == 1) sum -= customers[i-X];
            ret = max(ret, sum);
        }
        return ret;
    }
};
