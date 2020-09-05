class Solution {
public:
    int minTotalDistance(vector<vector<int>>& grid) {
        vector<int>x;
        vector<int>y;
        
        for (int i = 0; i < grid.size(); i++)
            for (int j = 0;  j < grid[0].size(); j++)
                if (grid[i][j] == 1) {
                    x.push_back(i);
                    y.push_back(j);
                }
    
        sort(x.begin(), x.end());
        sort(y.begin(), y.end());
        int m = x[x.size()/2];
        int n = y[y.size()/2];
    
        int ret = 0;
        for (int i = 0; i < grid.size(); i++)
            for (int j = 0;  j < grid[0].size(); j++)
                if (grid[i][j] == 1) {
                    ret += abs(i-m) + abs(j-n);
                }
    
        return ret;
    }
};


// median point

// P: |x1-x| + |y1-y| + |x2-x| + |y2-y| + .... + |xn-x| + |yn -y|
// x: argmin (|x1-x| + |x2-x| + .... + |xn-x|);
// y: argmin (|y1-y| + |y2-y| + .... + |yn -y|);

// x: argmin (|x1-x| + |x2-x| + .... + |xn-x|);
//   = median of (xi)
      
// *  *    *   *  *
