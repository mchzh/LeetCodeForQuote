class Solution {
public:
    vector<int>Father;
    int minSwapsCouples(vector<int>& row) {
        int N = row.size();
        Father.resize(N);
        
        for (int i = 0; i < N; i+=2) {
            Father[i] = i;
            Father[i+1] = i;
        }
        
        // connected different couple to comman parent
        for (int i = 0; i < N; i+=2) {
            int a = row[i];
            int b = row[i+1];
            if (FindFather(a) != FindFather(b)) 
                Union(a, b);
        }
        
        // handle group information with map
        unordered_map<int, int>count;
        for (int i = 0; i < N; i++) {
            count[FindFather(i)] += 1;
        }
        
        // get the result
        int ret = 0;
        for (auto val : count) {
            ret += val.second/2 -1;
        }
        return ret;
    }
    
    void Union(int x, int y) {
        x = Father[x];
        y = Father[y];
        if (x < y) 
            Father[y] = x;
        else
            Father[x] = y;
    }
    
    int FindFather(int x) {
        if (Father[x] != x)
            Father[x] = FindFather(Father[x]);
        return Father[x];
    }
};
