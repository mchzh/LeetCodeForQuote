class Solution {
public:
    unordered_map<int, int>Father;
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int>setNum(nums.begin(), nums.end());
        
        for (int i = 0; i < nums.size(); i++) {
            int x = nums[i];
            if (Father.find(x) == Father.end()) 
                Father[x] = x;
            
            if ( Father.find(x-1) != Father.end() && FindFather(x-1) != FindFather(x) ) 
                Union(x-1, x);
            
            if ( Father.find(x+1) != Father.end() && FindFather(x+1) != FindFather(x) ) 
                Union(x+1, x);
        }
        
        // path compression
        for (auto x : setNum)
            Father[x] = FindFather(x);
        
        unordered_map<int, int>count;
        for (auto x : setNum) {
            count[Father[x]] += 1;
        }
        
        int len = 0;
        for (auto a : count) {
            len = max(len, a.second);
        }
        return len;
    }
    
    int FindFather(int x) {
        if (Father[x] != x) {
            Father[x] = FindFather(Father[x]);
        }
        return Father[x];
    }
    void Union(int x, int y) {
        x = FindFather(x);
        y = FindFather(y);
        if (x < y) {
            Father[x] = y;
        } else {
            Father[y] = x;
        }
    }
};

// x->y->w->z
