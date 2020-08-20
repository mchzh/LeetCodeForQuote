class Solution {
public:
    int jobScheduling(vector<int>& startTime, vector<int>& endTime, vector<int>& profit) {
        vector<vector<int>>jobs;
        for (int i = 0; i < startTime.size(); i++) {
            jobs.push_back( {endTime[i], startTime[i], profit[i]} );
            jobs.push_back( {startTime[i], 0, INT_MIN} );
        }
        sort(jobs.begin(), jobs.end()); // sort two times
        
        unordered_map<int, int> time2val;
        time2val[0] = 0;
        
        int curVal = 0;
        for (auto job : jobs) {
            int end = job[0];
            int start = job[1];
            int val = job[2];
            
            time2val[end] = max(curVal, time2val[start] + val);
            curVal = time2val[end];
        }
        return curVal;
    }
};
