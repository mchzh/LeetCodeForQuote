class Solution {
public:
    int minDeletionSize(vector<string>& A) {
        int m = A.size(), n = A[0].size();
        vector<int>p(m, 0);
        int rets = 0;
        for (int j = 0; j < n; j++) {
            vector<int>p2 = p;
            int flag = true;
            for (int i = 1; i < m; i++) {
                if (p2[i] == 1) continue;
                if (p2[i] == 0) {
                    if (A[i-1][j] < A[i][j]) {
                        p2[i] = 1;
                    } else if (A[i-1][j] == A[i][j]) {
                        p2[i] = 0;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                p = p2;
            } else {
                rets += 1;
            }
        }
        return rets;
    }
};
