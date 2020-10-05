class Solution {
    unordered_set<int>stoneSet;
    
    set<pair<int, int>>memo;
public:
    bool canCross(vector<int>& stones) {
        for (auto s : stones) {
            stoneSet.insert(s);
        }
        
        return dfs(stones, 0, 0);
    }
    bool dfs(vector<int>& stones, int pos, int jump) {
        // base case
        if (pos == stones.back()) return true;
        if (stoneSet.find(pos) == stoneSet.end()) return false; // river
        
        if ( memo.find({pos, jump}) != memo.end() ) return false;
        
        if (jump > 1 && dfs(stones, pos+jump-1, jump-1)) {
            return true;
        }
        if (jump > 0 && dfs(stones, pos+jump, jump)) {
            return true;
        }
        if (dfs(stones, pos+jump+1, jump+1)) {
            return true;
        }
        memo.insert({pos, jump});
        return false;
    }
};

// dfs + memo
// X X X X X X
//    k-1 k k+1
