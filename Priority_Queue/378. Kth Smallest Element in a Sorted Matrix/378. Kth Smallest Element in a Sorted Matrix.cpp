class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int N = matrix.size();
        set<vector<int>>Set;
        Set.insert({matrix[0][0], 0, 0});
        
        int count = 0;
        while (count < k) {
            int val = (*Set.begin())[0];
            int x = (*Set.begin())[1];
            int y = (*Set.begin())[2];
            //pop first element
            Set.erase(Set.begin());
            count++;
            if (count == k) return val;
            
            if (y+1 < N)
                Set.insert({matrix[x][y+1], x, y+1});
            if (x+1 < N)
                Set.insert({matrix[x+1][y], x+1, y});
                 
        }
        
        return -1;
    }
};
