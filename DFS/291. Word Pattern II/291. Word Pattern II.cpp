class Solution {
public:
    // https://leetcode.com/problems/word-pattern-ii/discuss/73666/Share-my-C%2B%2B-backtracking-solution
    unordered_map<char, string>pDict;
    unordered_map<string, char>sDict;
    bool wordPatternMatch(string pattern, string str) {
        return isMatch(pattern, 0, str, 0);
    }
    bool isMatch(string &pattern, int i, string &str, int j) {
        // base case
        int m = pattern.size();
        int n = str.size();
        if (i == m || j == n) {
            if (i == m && j == n) return true;
            return false;
        }
        
        for (int k = j; k < n; k++) {
            bool ins = false;
            string cur = str.substr(j, k-j+1);
            
            // exist char related string
            if ( pDict.find(pattern[i]) != pDict.end() ) {
                if (pDict[pattern[i]] != cur) continue;
            } else if ( sDict.find(cur) != sDict.end() ) {
                if (sDict[cur] != pattern[i]) continue;
            } else {
                pDict[pattern[i]] = cur;
                sDict[cur] = pattern[i];
                ins = true;
            }
            if (isMatch(pattern, i+1, str, k+1)) return true;
            if (ins) { // backtracking
                pDict.erase(pattern[i]);
                sDict.erase(cur);
            }
        }
        
        return false;
    }
};
