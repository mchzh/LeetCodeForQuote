class Solution {
public:
    vector<int> numMovesStones(int a, int b, int c) {
        vector<int>p({a, b, c});
        sort(p.begin(), p.end());
        
        int x, y;
        if (p[0]+1 == p[1] && p[1]+1==p[2]) 
            x = 0;
        else if (p[0]+1 == p[1] || p[1]+1==p[2]) // adjacent
            x = 1;
        else if (p[0]+2 == p[1] || p[1]+2==p[2])
            x = 1;
        else 
            x = 2;
        
        y = p[2]-p[0]-2;
        return {x, y};
    }
};

// O__O___O
// O_O___O
// OO___O
// OOO

// max
// ->O____O____O<-
