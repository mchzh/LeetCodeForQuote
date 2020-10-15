class Solution {
public:
    int minMeetingRooms(vector<vector<int>>& intervals) {
        // sweep line
        int N = intervals.size();
        if (N == 0) return 0;
        vector<int>start;
        vector<int>end;
        
        for (int i = 0; i < N; i++) {
            start.push_back(intervals[i][0]);
            end.push_back(intervals[i][1]);
        }
        sort(start.begin(), start.end());
        sort(end.begin(), end.end());
        
        // scan from start
        int i = 0, j = 0;
        int rets = 0, count = 0;
        while (i < N) {
            if (start[i] < end[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            rets = max(rets, count);
        }
        return rets;
    }
};
