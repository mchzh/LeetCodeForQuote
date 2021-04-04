class Solution {
public:
    string orderlyQueue(string S, int K) {
        if (K >= 2) { // srot this string
            sort(S.begin(), S.end());
            return S;
        }
        
        string rets = S;
        for (int i = 0; i < S.size(); i++) {
            S = S.substr(1) + S.substr(0, 1);
            if (rets > S) rets = S;
        }
        return rets;
    }
};
