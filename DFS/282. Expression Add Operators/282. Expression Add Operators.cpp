class Solution {
    vector<string> rets;
public:
    vector<string> addOperators(string num, int target) {
        DFS(num, (long long)target, 0, 0, 0, "");
        return rets;
    }
    void DFS(string& num, long long target, int pos, long long preval, long long lastval, string prestr) {
        // corner case
        if (pos == num.size()) {
            if (preval == target) rets.push_back(prestr);
        }
        
        for (int i = pos+1; i <= num.size(); i++) {
            string cur = num.substr(pos, i-pos);
            // leading zero
            if (cur.size() > 1 && cur[0] == '0') continue;
            long long curval = stoll(cur);
            
            if (pos == 0) {
                DFS(num, target, i, preval+curval, curval, prestr + cur); //non
            } else {
                DFS(num, target, i, preval+curval, curval, prestr + "+" + cur); //+
                DFS(num, target, i, preval-curval, -curval, prestr + "-" + cur); //-
                DFS(num, target, i, preval-lastval + lastval*curval, lastval*curval, prestr + "*" + cur); //*
            }  
        }
    }
};
