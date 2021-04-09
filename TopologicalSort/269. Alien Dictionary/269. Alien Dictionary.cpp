class Solution {
public:
    string alienOrder(vector<string>& words) {
        //if (words == NULL || words.size() == 0) return "";
        unordered_map<char, unordered_set<char>> next;
        unordered_map<char, int> inDegree;
        for (auto w : words) {
            for (auto c : w) inDegree[c] = 0;
        }
        
        for (int i = 0; i < words.size()-1; i++) {
            string s = words[i];
            string t = words[i+1];
            if (s.size() > t.size() && s.substr(0, t.size()) == t) return "";
            
            for (int j = 0; j < min(s.size(), t.size()); j++) {
                if (s[j] == t[j]) continue;
                if (next[s[j]].find(t[j]) == next[s[j]].end()) { // first different place will exit
                    next[s[j]].insert(t[j]);
                    inDegree[t[j]]++;
                }
                break;
            }
        }
        
        // topology sort(BFS)
        queue<char> q;
        
        for (auto x : inDegree) {
            if (x.second == 0)  q.push(x.first);
        }
        
        string ret;
        while (!q.empty()) {
            char cur = q.front();
            q.pop();
            ret.push_back(cur);
            
            for (auto c : next[cur]) {
                inDegree[c]--;
                if (inDegree[c] == 0) q.push(c);
            }
        }
        
        return ret.size() == inDegree.size() ? ret : "";
    }
};
