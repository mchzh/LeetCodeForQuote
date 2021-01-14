class Solution {
    unordered_map<string, int>memo1;
    unordered_map<string, int>memo2;
public:
    int minimumOneBitOperations(int n) {
        string str = bitset<32>(n).to_string();
        return dfs(str);
    }
    int dfs(string n) {
        if (n.size() == 0) return 0;
        if (n == "0") return 0;
        if (n == "1") return 1;
        if (memo1.find(n) != memo1.end()) 
            return memo1[n];
        
        // recursion
        // first remove lead zero
        if (n[0] == '0') return dfs(n.substr(1));
        // get the rest n-1 char
        string m = n.substr(1);
        string p = m;
        p[0] = '1';
        for (int i = 1; i < m.size(); i++) {
            p[i] = '0';
        }
        
        memo1[n] = helper(m) + 1 + dfs(p);
        return memo1[n];
    }
    
    int helper(string n) {
        if (n.size() == 0) return 0;
        if (n == "0") return 1;
        if (n == "1") return 0;
        if (memo2.find(n) != memo2.end()) 
            return memo2[n];
        
        // recursion
        if (n[0] == '1') {
            memo2[n] = dfs(n.substr(1));
        } else {
            string m = n.substr(1);
            string p = m;
            p[0] = '1';
            for (int i = 1; i < m.size(); i++) {
                p[i] = '0';
            }
            
            memo2[n] = helper(m) + 1 + dfs(p);
        }
        return memo2[n];
    }
};
