class Solution {
public:
    vector<int> decode(vector<int>& encoded) {
        int n = encoded.size()+1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum ^= i;
        }
        
        int noheadSum = 0;
        for (int i = 1; i < encoded.size(); i+=2) {
            noheadSum ^= encoded[i];
        }
        vector<int>ret(n);
        ret[0] = sum ^ noheadSum;
        for (int i = 1; i < n; i++) {
            ret[i] = encoded[i-1]^ret[i-1];
        }
        
        return ret;
    }
};
