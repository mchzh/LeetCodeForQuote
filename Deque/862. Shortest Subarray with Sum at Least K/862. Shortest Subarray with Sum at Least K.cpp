class Solution {
public:
    int shortestSubarray(vector<int>& A, int K) {
        int N = A.size();
        A.insert(A.begin(), 0);
        vector<int>presum(N+1, 0);
        for (int i = 1; i <= N; i++)
            presum[i] = presum[i-1] + A[i];
        
        deque<int>q({0});
        int rets = INT_MAX/2;
        for (int j = 1; j <=N; j++) {
            int i = INT_MIN/2;
            while (q.size() > 0 && presum[q.front()] <= presum[j] - K) {
                i = q.front();
                q.pop_front();
            }
            rets = min(rets, j-i);
            // add j into deque
            while (q.size() > 0 && presum[q.back()] >=  presum[j])
                q.pop_back();
            q.push_back(j);
        }
        return rets == INT_MAX/2 ? -1 : rets;
    }
};
