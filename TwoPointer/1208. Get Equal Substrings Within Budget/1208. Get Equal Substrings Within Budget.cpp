class Solution {
public:
    int equalSubstring(string s, string t, int maxCost) {
        int left = 0;
        int N = s.size();
        int rets = 0;
        
        int cost = 0;
        for (int j = 0; j < N; j++) {
            char sc = s[j];
            char tc = t[j];
            if (sc != tc) {
                cost += abs(sc - tc);
            }
            if (cost <= maxCost) {
                rets = max(rets, j-left+1);
            }
            while (left <= j && cost > maxCost) { // consider "=" condition
                char lsc = s[left];
                char ltc = t[left];
                if (lsc != ltc) cost -= abs(lsc - ltc);
                left++;
            }
        }
        return rets;
    }
};
