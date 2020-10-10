class Solution {
    static bool cmp(vector<int>& a, vector<int>& b) {
        return a[1]<b[1];
    }
public:
    int findMinArrowShots(vector<vector<int>>& points) {
        int N = points.size();
        if (N == 0) return 0;

        // sort by x_end
        sort(points.begin(), points.end(), cmp);
        
        int count = 0;
        for (int i = 0; i < N;) {
            int right = points[i][1];
            int j = i+1; 
            while (j < N && points[j][0] <= right) j++;
            count++;
            i = j;
        }
        return count;
    }
};
