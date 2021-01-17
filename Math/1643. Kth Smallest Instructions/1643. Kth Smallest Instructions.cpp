class Solution {
public:
    string kthSmallestPath(vector<int>& destination, int k) {
        int H = destination[1];
        int V = destination[0];
        int n = H+V;
        
        string ret;
        for (int i = 0; i < n; i++) {
            if (H == 0) {
                ret.push_back('V');
                V--;
                continue;
            } else if (V == 0) {
                ret.push_back('H');
                H--;
                continue;
            }
            
            // discuss with H and V as head
            int restComb = comb(H-1+V, V);
            if (k <= restComb) {
                ret.push_back('H');
                H--;
            } else {
                ret.push_back('V');
                V--;
                k -= restComb;
            }
        }
        return ret;
    }
    
    long long comb(int n, int m)
    {        
        long long cnt = 1;
        for(int i = 0; i < m; i++){
            cnt *= n - i;
            cnt /= i + 1;
        }
        return cnt;
    }
};
